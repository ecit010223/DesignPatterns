package com.year2018.effective_java.item75;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * Author: zyh
 * Date: 2018/11/6 14:17
 * 可采用默认的序列化形式
 */
public class Name implements Serializable {
    /**
     * Last Name. Must be non-null
     * @serial
     */
    private final String lastName;

    /**
     * First name. Must be non-null
     * @serial
     */
    private final String firstName;

    /**
     * Middle name. or null if there is none.
     * @serial
     */
    private final String middleName;

    public Name(String lastName,String firstName,String middleName){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeObject(lastName);
        s.writeObject(firstName);
        s.writeObject(middleName);
    }

    private void readObject(ObjectInputStream s) throws IOException,ClassNotFoundException{
        s.defaultReadObject();
        if(s.readObject()==null){
            throw new NullPointerException("please input last name");
        }
        if(s.readObject()==null){
            throw new NullPointerException("please input first name");
        }
    }
    //...
}
