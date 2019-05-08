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
    
    private String pId; //鐖惰妭鐐筰d
    
    private String text;
    
    private String state;
    
    private String url;
    
    private Map<String, Object> attributes = new HashMap<String, Object>(); // 娣诲姞鍒拌妭鐐圭殑鑷畾涔夊睘鎬�
    
    private List<MenuTree> children; //瀛愯妭鐐规暟鎹�

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

	public List<MenuTree> getChildren() {
		return children;
	}

	public void setChildren(List<MenuTree> children) {
		this.children = children;
	}
    
    
}
