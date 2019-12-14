package com.neu.autojavaappgenerator.Services;

import HibernateAnnotator.HibernateAnnotator;
import com.sun.codemodel.JCodeModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.*;
import java.net.URL;

//todo add primary key to entity
//findXYZByID
public class JsonReader {

    public static void main(String[] args){

        parseJson();
        String title = readJsonAndGetTitle();
        codeGenerator(title,"src/main/resources/RepoTemplate.txt", "Repository");
        codeGenerator(title, "src/main/resources/ServiceTemplate.txt","Service");
        codeGenerator(title, "src/main/resources/ControllerTemplate.txt", "Controller");
    }


    //Generates code based on the template given. Inserts title into the template to produce legible and usable code.
    //Takes in
    //title - name to be used for variables/classes
    //Template - template to be used for generating code
    //Type - one of three types of code "Repository", "Service", "Controller" - this tells the us where to save the code

    private static void codeGenerator(String title, String template, String type){

        try(FileReader reader = new FileReader(template)){

            BufferedReader br = new BufferedReader(reader);
            String line;
            String smallTitle = title.toLowerCase();
            String normalTitle = smallTitle.substring(0, 1).toUpperCase() + smallTitle.substring(1);
            File opFile = null;
            switch(type){
                case "Repository":
                    opFile = new File("C:\\Users\\Harsh Mehta\\Desktop\\auto-java-app-generator\\" +
                            "src\\main\\java\\com\\neu\\autojavaappgenerator\\Repository\\"+normalTitle+"Repository.java");
                    break;
                case "Service":
                    opFile = new File("C:\\Users\\Harsh Mehta\\Desktop\\auto-java-app-generator\\" +
                            "src\\main\\java\\com\\neu\\autojavaappgenerator\\Services\\"+normalTitle+"Service.java");
                    break;
                case "Controller":
                    opFile = new File("C:\\Users\\Harsh Mehta\\Desktop\\auto-java-app-generator\\" +
                            "src\\main\\java\\com\\neu\\autojavaappgenerator\\Controllers\\"+normalTitle+"Controller.java");
                    break;
                default:
                    break;
            }
            if (opFile!=null){
                BufferedWriter writer = new BufferedWriter(new FileWriter(opFile));

                while((line = br.readLine()) != null){
                    //process the line
                    line = line.replaceAll("!Sample!",normalTitle);
                    line = line.replaceAll("!_sample!",smallTitle);
                    System.out.println(line);
                    writer.append(line);
                    writer.append("\n");
                }
                writer.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Simply reads the given json file and returns the class name/object name (defined as title in our json file)

    private static String readJsonAndGetTitle(){

        JSONParser jsonParser = new JSONParser();

        try(FileReader reader = new FileReader("src/main/resources/user.json")){

            //Read Json
            JSONObject obj = (JSONObject) jsonParser.parse(reader);

            return (String) obj.get("title");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    //Parses json file, creates entity/model classes and annotates the classes.
    //Uses a custom annotator to add "Entity", "Table" and "Column" annotations to the class/fields.

    private static void parseJson(){


        JsonReader j = new JsonReader();
        Class cls = j.getClass();

        JCodeModel codeModel = new JCodeModel();
        URL source = cls.getResource("/user.json");
        System.out.println("URL = "+source);

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() { // set config option by overriding method
                return true;
            }

            @Override
            public boolean isUseTitleAsClassname() {
                return true;
            }

            @Override
            public boolean isIncludeAdditionalProperties() {
                return false;
            }


        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new HibernateAnnotator(), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, "ClassName", "com.neu.autojavaappgenerator.Models", source);


        try {
            File dest = new File("src/main/java");
            codeModel.build(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
