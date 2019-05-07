package com.jk.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuTree implements Serializable {
    /**
	 * serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -5110015530439064016L;

	private String id;
    
    private String pId; //父节点id
    
    private String text;
    
    private String state;
    
    private String url;
    
    private Map<String, Object> attributes = new HashMap<String, Object>(); // 添加到节点的自定义属性
    
    private List<MenuTree> nodes; //子节点数据

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<MenuTree> getNodes() {
		return nodes;
	}

	public void setNodes(List<MenuTree> nodes) {
		this.nodes = nodes;
	}

    
}
