package cz.spsmb.repository;

import cz.spsmb.model.UserEntity;
import cz.spsmb.repository.anotation.Column;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileUserRepository implements UserRepository {

    private String pathName;

    public FileUserRepository(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public void save(List<UserEntity> userEntity) {

    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> userEntities = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File(pathName)));
            String firstLine = scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(";");
                UserEntity userEntity = parseUserEntity(items, firstLine);
                userEntities.add(userEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userEntities;
    }

    private int findItemIndex(String[] array, String itemName) {
        for(int i = 0; i < array.length; i++) {
            if(array[i].compareTo(itemName) == 0)
                return i;
        }
        return -1;
    }

    private UserEntity parseUserEntity(String[] items, String firstLine) throws IllegalAccessException {
        String[] fistLineItems = firstLine.split(";");
        UserEntity userEntity = new UserEntity();
        Field[] entityFields = UserEntity.class.getDeclaredFields();
        for(Field field : entityFields) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                field.setAccessible(true);
                String columnName = column.name();
                Class<?> type = field.getType();
                String stringValue =  items[findItemIndex(fistLineItems, columnName)];
                Object value = getParsedValueByType(type, stringValue);
                field.set(userEntity, value);
                field.setAccessible(false);
            }
        }
        return userEntity;
    }

    private Object getParsedValueByType(Class<?> type, String stringValue) {
        if(type == Long.class) {
            return Long.parseLong(stringValue);
        }
        if(type == String.class){
            return stringValue;
        }
        if(type == Boolean.class) {
            return Boolean.parseBoolean(stringValue);
        }
        return null;
    }
}
