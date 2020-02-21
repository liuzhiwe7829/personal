package com;

import com.bom.Apply;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhm
 */
public class TestReflect {

	public static void main(String[] args) throws IllegalAccessException {
//		Class<?> apply = Class.forName("com.bom.Apply");
        Apply apply = new Apply();
        Field[] fields = apply.getClass().getDeclaredFields();
//		Field[] fields = apply.getClass().getFields();
		//获取所有属性
		List allFieldList = getBomFields1(new ArrayList(), fields);
		for (Object item : allFieldList) {
			List<Field> list = (List) item;
			Field field ;
			if(list.size() >1) {
				field = list.get(list.size() - 1);
			}else{
				field = list.get(0);
			}
			String name = field.getName();
			String type = field.getType().toString();
			if(type.contains("class")){
				type = type.substring(type.lastIndexOf(".")+1);
			}
			String attr =  field.getDeclaringClass().getName();
			attr = attr.substring(attr.lastIndexOf(".")+1);
			System.out.println(type+"_"+attr+"_"+name);
		}
	}
	public static List getBomFields1(List chain,
									 Field[] fields) {
		List result = new ArrayList();
		for (Field field : fields) {
			Class<?> fieldClass = field.getType();
			//得到属性
			field.setAccessible(true);
			//获取属性
			String name = field.getName();
			//获取属性值
//			Object value = field.get(obj);
			if (fieldClass.isPrimitive()
					|| fieldClass.getName().startsWith("java.lang")
					|| fieldClass.getName().startsWith("java.util.Date")
					|| fieldClass.getName().startsWith("javax")
					|| fieldClass.getName().startsWith("com.sun")
					|| fieldClass.getName().startsWith("sun")
					|| fieldClass.getName().startsWith("boolean")
					|| fieldClass.getName().startsWith("double")
					|| fieldClass.getName().startsWith("int")) {
				List endChain = new ArrayList(chain);
				endChain.add(field);
				result.add(endChain);
				continue;
			} else {
				if (fieldClass.isAssignableFrom(List.class))
				{
					// 关键的地方，如果是List类型，得到其Generic的类型
					Type fc = field.getGenericType();
					// 【3】如果是泛型参数的类型
					if (fc instanceof ParameterizedType)
					{
						ParameterizedType pt = (ParameterizedType) fc;
						// 【4】
						Class genericClazz = (Class) pt.getActualTypeArguments()[0];
						//设置list的终止类型
						if (genericClazz.getName().startsWith("java.lang")
								|| genericClazz.getName().startsWith("java.util.Date")
								|| genericClazz.getName().startsWith("javax")
								|| genericClazz.getName().startsWith("com.sun")
								|| genericClazz.getName().startsWith("sun")
								|| genericClazz.getName().startsWith("boolean")
								|| genericClazz.getName().startsWith("double")
								|| genericClazz.getName().startsWith("int")) {
							continue;
						}
						// 得到泛型里的class类型对象。
						List thisChain = new ArrayList(chain);
						thisChain.add(field);
						result.addAll(getBomFields1(new ArrayList(thisChain), genericClazz.getDeclaredFields()));
					}
				} else {
					List thisChain = new ArrayList(chain);
					thisChain.add(field);
					result.addAll(getBomFields1(new ArrayList(thisChain),
							fieldClass.getDeclaredFields()));
				}

			}
		}
		return result;
	}
}