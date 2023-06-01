//package com.pritam.ayushman.reflection.work;
//
//import java.lang.reflect.*;
//import java.math.BigDecimal;
//
//public class ReflectionTestDemo {
//
//    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//
//        System.out.println(ReflectionTestDemo.class.getName());
//        String FULLY_QUALIFIED_CLASS_NAME = "com.pritam.ayushman.reflection.work.Process";//Process.class.getName()
//        Class<?> aClazz = Class.forName(FULLY_QUALIFIED_CLASS_NAME);
////      Class<?> aClazz = Class.forName(Process.class.getName());
//
//        Class<?>[] constructorArgsTypes = {Department.class,String.class};
//        Constructor<?> classConstructor = aClazz.getDeclaredConstructor(constructorArgsTypes);
//        classConstructor.setAccessible(true);
//        Department department = new Department(780,"HR");
//        String message = "hello, how are you.";
//        Object[] constructorArgsValues = { department ,message};
//
//        Object classObject = classConstructor.newInstance(constructorArgsValues);
//
//        String methodName = "launchProcess";
//        Class<?>[] methodArgsTypes = {Employee.class, BigDecimal.class};
//        Method method = aClazz.getDeclaredMethod(methodName, methodArgsTypes);
//        method.setAccessible(true);
//        Employee employee = new Employee("Ravan","Ayushman");
//        Object[] methodArgsValues = { employee, new BigDecimal("22222") };
//
//        Object methodResult = method.invoke(classObject, methodArgsValues);
//        System.out.println("methodResult is : "+methodResult);
//
//        // Static methods call
//        methodName = "stopProcess";
//        Class<?>[] staticMethodArgsTypes = { Integer.class };
//        method = aClazz.getDeclaredMethod(methodName, staticMethodArgsTypes);
//        method.setAccessible(true); //if security settings allow this
//        method.invoke(null, 23); //use null if the method is static
//
//        //////////////////////////////////////////////////////
////        Field[] field = classObject.getClass().getDeclaredFields();
//        for(Field field : classObject.getClass().getDeclaredFields()){
//            field.setAccessible(true);
//            String fieldName = field.getName();
//            Class<?> fieldType = field.getType();
//            Object fieldValue = field.get(classObject);
//            System.out.println("fieldName is : "+fieldName +" fieldType is : "+fieldType +" fieldValue is : "+fieldValue);
//        }
//
////        getConstructor, getConstructors, getDeclaredConstructor
////        getMethod, getMethods, getDeclaredMethods
////        getField, getFields, getDeclaredFields
////        getSuperclass
////        getInterfaces
////        getDeclaredClasses
//    }
//}
