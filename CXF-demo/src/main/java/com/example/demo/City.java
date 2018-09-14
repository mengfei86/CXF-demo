/**
 *
 * @date 2018年8月10日 下午7:04:10
 * @author zjm
 */
package com.example.demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.cxf.helpers.IOUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @date 2018年8月10日 下午7:04:10
 * @author zjm
 */
public class City {
	public static JSONObject json2tree1(JSONArray tmpList) {
		JSONObject jsonobj = new JSONObject();
		JSONObject tmpMap = new JSONObject();
		for (Object object : tmpList) {
			JSONObject jsontmp = (JSONObject) object;
			tmpMap.put(jsontmp.get("id").toString(), jsontmp);
		}
		for (Object object : tmpList) {
			JSONObject jsontmpss = (JSONObject) object;
			// 得到父节点
			JSONObject jsontmp = (JSONObject) tmpMap.get(jsontmpss.get("pid"));
			// 是否是根节点
			if (jsontmp != null) {
				String sonName = jsontmpss.getString("name");
				int end = sonName.length();
				int stat = getFSize(tmpMap, jsontmp);

				jsontmpss.put("name", sonName.substring(stat, end));

				if (jsontmp.get("children") == null) {
					JSONArray list = new JSONArray();
					list.add(jsontmpss);
					jsontmp.put("children", list);
				} else {
					((JSONArray) jsontmp.get("children")).add(jsontmpss);
				}
				tmpMap.put(jsontmpss.get("pid").toString(), jsontmp);
			} else {
				jsonobj = jsontmpss;
			}
		}

		return jsonobj;
	}

	public static JSONObject json2tree(JSONArray tmpList) {
		JSONObject jsonobj = new JSONObject();

		for (Object object : tmpList) {
			JSONObject jsontmpss = (JSONObject) object;
			jsontmpss.getString("fid");

		}

		return jsonobj;

	}

	public static JSONArray listToTree(JSONArray arr, String id, String pid, String child) {
		JSONArray r = new JSONArray();
		JSONObject hash = new JSONObject();
		// 将数组转为Object的形式，key为数组中的id
		for (int i = 0; i < arr.size(); i++) {
			JSONObject json = (JSONObject) arr.get(i);
			hash.put(json.getString(id), json);
		}
		// 遍历结果集
		for (int j = 0; j < arr.size(); j++) {
			// 单条记录
			JSONObject aVal = (JSONObject) arr.get(j);
			// 在hash中取出key为单条记录中pid的值
			JSONObject hashVP = (JSONObject) hash.get(aVal.get(pid).toString());
			// 如果记录的pid存在，则说明它有父节点，将她添加到孩子节点的集合中
			if (hashVP != null) {
				// 检查是否有child属性
				if (hashVP.get(child) != null) {
					JSONArray ch = (JSONArray) hashVP.get(child);
					ch.add(aVal);
					hashVP.put(child, ch);
				} else {
					JSONArray ch = new JSONArray();
					ch.add(aVal);
					hashVP.put(child, ch);
				}
			} else {
				r.add(aVal);
			}
		}
		return r;
	}

	public static int getFSize(JSONObject map, JSONObject json) {
		int size = 0;
		if (json != null) {
			size = json.getString("name").length();
			JSONObject jsontmp = (JSONObject) map.get(json.get("pid"));
			size += getFSize(map, jsontmp);
		}
		return size;
	}

	public static void main(String[] args) throws IOException {
		InputStream in = City.class.getResourceAsStream("/citys.json");
		String result = IOUtils.toString(in, "UTF-8");
		System.out.println(result);
		JSONArray object = JSON.parseArray(result);
		System.out.println(((JSONObject) object.get(1)).get("id"));
		JSONArray a = City.listToTree(object, "id", "pid", "children");
		System.out.println(a.toJSONString());
	}
}
