

package hello.model;

public class XmlDocument {
    private String xmlData;

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }

    @Override
    public String toString() {
        if (xmlData == null) {
            return "XmlDocument{}";
        }
        return "XmlDocument{xmlData='" + xmlData + "'}";
    }
}