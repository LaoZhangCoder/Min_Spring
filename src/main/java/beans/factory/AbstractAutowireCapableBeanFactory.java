package beans.factory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map.Entry;

public abstract class AbstractAutowireCapableBeanFactory {

	public void populateBean(Entry<String, String> entry, Class<?> cl, Object bean) throws Exception {

		String value = entry.getValue();
		String key = entry.getKey();
		if (!(value.charAt(value.length() - 1) == '.')) {
			Field field = cl.getDeclaredField(key);
			field.setAccessible(true);
			Class<?> type = field.getType();
			
			if (type.toString().equals("int")) {
				int value1 = Integer.parseInt(value);
				field.setInt(bean, value1);

			} else if (type.toString().equals("class java.lang.Integer")) {
				Integer value1 = Integer.parseInt(value);
				Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
						value1.getClass());
				method.invoke(bean, value1);

			} else if (type.toString().equals("byte")) {

				byte value1 = Byte.parseByte(value);
				field.setByte(bean, value1);
			} else if (type.toString().equals("class java.lang.Byte")) {

				Byte value1 = Byte.parseByte(value);
				Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
						value1.getClass());
				method.invoke(bean, value1);
			} else if (type.toString().equals("short")) {

				short value1 = Short.parseShort(value);
				field.setShort(bean, value1);
			} else if (type.toString().equals("class java.lang.Short")) {

				Short value1 = Short.parseShort(value);
				Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
						value1.getClass());
				method.invoke(bean, value1);
			} else if (type.toString().equals("long")) {

				Long value1 = Long.parseLong(value);
				field.setLong(bean, value1);

			} else if (type.toString().equals("class java.lang.Long")) {

				Long value1 = Long.parseLong(value);
				Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
						value1.getClass());
				method.invoke(bean, value1);
			} else if (type.toString().equals("float")) {

				float value1 = Float.parseFloat(value);
				field.setFloat(bean, value1);

			} else if (type.toString().equals("class java.lang.Float")) {

				Float value1 = Float.parseFloat(value);
				Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
						value1.getClass());
				method.invoke(bean, value1);
			} else if (type.toString().equals("double")) {

				double value1 = Double.parseDouble(value);
				field.setDouble(bean, value1);

			} else if (type.toString().equals("class java.lang.Double")) {

				Double value1 = Double.parseDouble(value);
				Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
						value1.getClass());
				method.invoke(bean, value1);
			} else if (type.toString().equals("char")) {

				char value1 = value.charAt(0);
				if (value.length() > 1) {
					throw new RuntimeException("char类型不能超过两个字符!");
				}
				field.setChar(bean, value1);

			} else if (type.toString().equals("class java.lang.Character")) {
				if (value.length() > 1) {
					throw new RuntimeException("char类型不能超过两个字符!");
				}
				Character value1 = value.charAt(0);
				Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
						value1.getClass());
				method.invoke(bean, value1);

			} else if (type.toString().equals("boolean")) {

				boolean value1 = Boolean.parseBoolean(value);
				field.setBoolean(bean, value1);
			} else if (type.toString().equals("class java.lang.Boolean")) {

				Boolean value1 = Boolean.parseBoolean(value);
				Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
						value1.getClass());
				method.invoke(bean, value1);
			} else {

				Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
						value.getClass());
				method.invoke(bean, value);

			}

		}

	}
	/*
	 * private void setvalue(String key,Class<?> cl, Object bean,int value) throws
	 * Exception {
	 * 
	 * Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() +
	 * key.substring(1), value.); method.invoke(bean, value);
	 * 
	 * }
	 */
}
