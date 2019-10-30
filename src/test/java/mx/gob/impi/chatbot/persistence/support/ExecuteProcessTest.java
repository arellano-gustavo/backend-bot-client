package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class ExecuteProcessTest {
    //https://stackoverflow.com/questions/27868569/execute-shell-script-in-java-and-read-output
    public static void main(String[] args) throws Exception {
        List<String> response = new ArrayList<>();
        String[] command = { "/Users/garellano/Desktop/myscript.sh", "key", "ls -t | tail -n 1" };
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
            process.getInputStream()));
        String s;
        while ((s = reader.readLine()) != null) {
          response.add(s);
        }
        for(String ss : response) {
            System.out.println("--->" + ss + "<---");
        }
        //System.out.println(ok(response.get(0)));
        String jsonResponse = "{'name':{'apellidos':{'paterno':'arellano','materno':'sandoval'}}, 'location':['uno','dos'] }";
        String jsonQuery = "$.name.apellidos.materno";
        // ¿como pregunto si alguno de los nodos contiene un arreglo en el cual al menos uno de sus valores es 'hola' ?

        boolean result = testResultExpression(jsonResponse, jsonQuery, "sandoval");
        if(result) {
            System.out.println("Se verificó el resultado");
        } else {
            System.out.println("No se verificó el resultado");
        }
    }

    @Test
    public void pba() {
        String jsonResponse = "{'name':{'apellidos':{'paterno':'arellano','materno':'sandoval'}}, 'location':['uno','dos'] }";
        String jsonQuery = "$.name.apellidos.materno";
        String resultToCompare = "sandoval";
        // ¿como pregunto si alguno de los nodos contiene un arreglo en el cual al menos uno de sus valores es 'hola' ?
        boolean result = testResultExpression(jsonResponse, jsonQuery, resultToCompare);
        assertTrue("Error !!! No se verificó el resultado", result);
        assertFalse("Error !!! Se verificó el resultado", !result);
    }

    public static String ok(String jsonDataSourceString) {
        String jsonpathCreatorNamePath = "$.name.apellidos.materno";
        String jsonpathCreatorLocationPath = "$.location.*";
        DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
        String jsonpathCreatorName = jsonContext.read(jsonpathCreatorNamePath);
        List<String> jsonpathCreatorLocation = jsonContext.read(jsonpathCreatorLocationPath);
        for(String s : jsonpathCreatorLocation) {
            System.out.println(s);
        }
        return jsonpathCreatorName;
    }

    private static boolean testResultExpression(String jsonInput, String jsonQuery, String resultToCompare) {
        DocumentContext jsonContext = JsonPath.parse(jsonInput);
        String result = jsonContext.read(jsonQuery);
        return resultToCompare.equals(result);
    }
}
