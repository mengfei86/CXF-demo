package com.example.demo.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.cxf.helpers.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

//<?xml version="1.0" encoding="UTF-8"?>
//<HNISI>
//    <Head>
//        <Version>1.0</Version>
//    </Head>
//    <Info>
//        <Output>
//            <HashParams>
//                <HashParam Name="MSG" Value="执行成功!"/>
//                <HashParam Name="message" Value=""/>
//                <HashParam Name="FHZ" Value="1"/>
//                <HashParam Name="code" Value="1"/>
//            </HashParams>
//            <DataPackage>
//                <DataSet DSName="DataSet">
//                    <Row RowID="1">
//                        <Col ColName="XTJGDM" ColValue="顺德区局"/>
//                        <Col ColName="JZLB" ColValue="特定门诊"/>
//                        <Col ColName="RYRQ" ColValue="2017-01-16"/>
//                        <Col ColName="GMSFHM" ColValue="440623195107073683"/>
//                    </Row>
//                    <Row RowID="2">
//                        <Col ColName="XTJGDM" ColValue="顺德区局"/>
//                        <Col ColName="JZLB" ColValue="特定门诊"/>
//                        <Col ColName="RYRQ" ColValue="2017-02-20"/>
//                        <Col ColName="GMSFHM" ColValue="440623195107073683"/>
//                    </Row>
//                </DataSet>
//            </DataPackage>
//        </Output>
//    </Info>
//</HNISI>
public class XMLTest {
	public static void main1(String[] args) throws IOException, DocumentException {
//		InputStream in = XMLTest.class.getResourceAsStream("/a.xml");
//		String result = IOUtils.toString(in, "UTF-8");
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/main/java/a.xml"));
//		得到head值
		Element node1 = (Element)document.selectSingleNode("/HNISI/Info/Output/HashParams/HashParam[@Name='MSG']");
		System.out.println(node1.attributeValue("Value"));
	}
	public static void main(String[] args) throws IOException, DocumentException {
//		InputStream in = XMLTest.class.getResourceAsStream("/a.xml");
//		String result = IOUtils.toString(in, "UTF-8");
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/main/java/a.xml"));
		Element node1 = (Element)document.selectSingleNode("/HNISI/Info/Output/DataPackage/DataSet[@DSName='DataSet']");
		//获取 Row数组
		List<Element> a = (List<Element>)document.selectNodes("/HNISI/Info/Output/DataPackage/DataSet[@DSName='DataSet']/Row");
		for (Element element : a) {
//			获取数组节点属性值
			List<Element> aaa= (List<Element>)element.selectNodes("Col");
			for (Element element2 : aaa) {
				System.out.println(element2.attributeValue("ColName"));
				System.out.println(element2.attributeValue("ColValue"));
			}
		}
		System.out.println(node1.asXML());
		System.out.println(a.size());
	}

}
