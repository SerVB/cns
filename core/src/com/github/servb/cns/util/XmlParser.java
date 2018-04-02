/*
 * Copyright 2018 SerVB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.servb.cns.util;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Document Builder Factory wrapper.
 *
 * @author SerVB
 */
public abstract class XmlParser {

    private static final DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();;

    private final File xmlFile;

    public XmlParser(final File xmlFile) throws ParserConfigurationException, SAXException, IOException {
        this.xmlFile = xmlFile;

        final DocumentBuilderFactory dbf = DBF;
//        f.setValidating(false);
        final DocumentBuilder db = dbf.newDocumentBuilder();
        final Document doc = db.parse(this.xmlFile);
        visit(doc, 0);
    }

    private void visit(final Node node, final int level) {
        final NodeList list = node.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            final Node childNode = list.item(i);
            process(childNode, level + 1);
            visit(childNode, level + 1);
        }
    }

    private void process(final Node node, final int level) {
//        for (int i = 0; i < level; i++) {
//            System.out.print('\t');
//        }
//        System.out.print(node.getNodeName());
        if (node instanceof Element) {
            final Element element = (Element) node;

            processElement(element, level);
        }
        System.out.println();
    }

    protected abstract void processElement(final Element element, final int level);

}
