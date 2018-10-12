package com.bioFish.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化对象工具
 * @ClassName: SerializeUtil
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月12日 下午5:43:50
 */
public class SerializeUtil {
	
	/**
	 * 序列化
	 * @Title: serialize
	 * @Description: TODO
	 * @param object
	 * @return
	 * @return: byte[]
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 反序列化
	 * @Title: unserialize
	 * @Description: TODO
	 * @param bytes
	 * @return
	 * @return: Object
	 */
	public static Object unserialize(byte[] bytes) {
		if (bytes == null)
			return null;
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
