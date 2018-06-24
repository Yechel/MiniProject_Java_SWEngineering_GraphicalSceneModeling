package Parser;


import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class SceneDescriptor {
  static final String PROJECT_PATH = System.getProperty("user.dir");
  private HashMap <String, String> _sceneAttributes;
  private HashMap <String, String> _cameraAttributes;
  HashMap <String, String> _ambientLightAttributes;
  ArrayList <HashMap <String, String>> _spheres;
  ArrayList <HashMap <String, String>> _triangles;

  public static void initializeFromXMLstring() {
    try {

      File file = new File("C:\\Java\\MiniProject_Java_SWEngineering_GraphicalSceneModeling\\src\\Parser\\sceneXMLparser");

      DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
              .newDocumentBuilder();

      Document doc = dBuilder.parse(file);


      if (doc.hasChildNodes()) {



      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }


  public static void main(String[] args) {
    initializeFromXMLstring();


  }
}










