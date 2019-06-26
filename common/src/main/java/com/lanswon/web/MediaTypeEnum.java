package com.lanswon.web;



/**
 * 媒体类型enum
 *
 * <P>
 *      根据RFC-6838编写的MediaType枚举类
 * </P>
 *
 * @author Jaswine
 */
public enum MediaTypeEnum {

	//-----Type Application----//

	/**
	 * Atom feeds
	 */
	APPLICATION_ATOM_XML("application/atom+xml"),

	APPLICATION_ECMASCRIPT("application/ecmascript"),

	APPLICATION_EDI_X12("application/EDI-X12"),

	APPLICATION_EDIFACT("application/EDIFACT"),

	APPLICATION_JSON("application/json"),

	APPLICATION_JSON_UTF8("application/json;charset=UTF-8"),

	APPLICATION_JAVASCRIPT("application/javascript"),

	APPLICATION_OCTET_STREAM("application/octet-stream"),

	APPLICATION_OGG("application/ogg"),

	APPLICATION_PDF("application/pdf"),

	APPLICATION_POSTSCRIPT("application/postscript"),

	APPLICATION_RDF_XML("application/rdf+xml"),

	APPLICATION_RSS_XML("application/rss+xml"),

	APPLICATION_SOAP_XML("application/soap+xml"),

	APPLICATION_FONT_WOFF("application/font-woff"),

	APPLICATION_XHTML_XML("application/xhtml+xml"),

	APPLICATION_XML("application/xml"),

	APPLICATION_XML_DTD("application/xml-dtd"),

	APPLICATION_XOP_XML("application/xop+xml"),

	APPLICATION_ZIP("application/zip"),

	APPLICATION_GZIP("application/gzip");



	private String contentType;

	MediaTypeEnum(String contentType){
		this.contentType = contentType;
	}


	public String getContentType() {
		return this.contentType;
	}
}
