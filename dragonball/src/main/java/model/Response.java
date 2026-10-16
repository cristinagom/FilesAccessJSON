package model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Response{

	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("links")
	private Links links;

	@JsonProperty("items")
	@JacksonXmlElementWrapper(localName = "items")
	@JacksonXmlProperty(localName = "item")
	private List<Character> characters;

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setCharacters(List<Character> characters){
		this.characters = characters;
	}

	public List<Character> getCharacters(){
		return characters;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"meta = '" + meta + '\'' + 
			",links = '" + links + '\'' + 
			",items = '" + characters + '\'' +
			"}";
		}
}