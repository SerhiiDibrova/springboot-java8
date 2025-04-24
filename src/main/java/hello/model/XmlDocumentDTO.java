

package hello.model;

import java.lang.Override;
import java.lang.String;

public class XmlDocumentDTO {
    private String xmlData;
    private Integer handle;

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }

    public Integer getHandle() {
        return handle;
    }

    public void setHandle(Integer handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return "XmlDocumentDTO{" +
                "xmlData='" + (xmlData != null ? xmlData : "") + '\'' +
                ", handle=" + (handle != null ? handle : "") +
                '}';
    }
}