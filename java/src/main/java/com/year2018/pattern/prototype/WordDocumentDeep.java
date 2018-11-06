package com.year2018.pattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * author：zyh
 * on: 2018/7/31 22:01
 * 深拷贝
 * 对其中的引用类型成员变量也进行的拷贝
 * 在开发中，为了减少错误，建议使用学拷贝，避免操作副本时影响原始对象的问题
 */
public class WordDocumentDeep implements Cloneable{
    /** 文本 **/
    private String mText;
    /** 图片名列表 **/
    private ArrayList<String> mImages = new ArrayList<>();

    public WordDocumentDeep(){
        System.out.println("-------------------WordDocument构造函数-------------------------");
    }

    /**
     * 该方法不是Cloneable接口中的，而是Object中方法。
     * Cloneable是一个标识接口，它表明这个类的对象是可拷贝的。
     * 如果没有实现Cloneable接口而调用了clone()函数将抛出异常。
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected WordDocumentDeep clone() throws CloneNotSupportedException {
        try{
            WordDocumentDeep doc = (WordDocumentDeep)super.clone();
            doc.mText = this.mText;
            // 对mImages对象也调用了clone()函数，进行深拷贝
            doc.mImages = (ArrayList<String>)this.mImages.clone();
            return doc;
        }catch (Exception e){

        }
        return null;
    }

    public String getText(){
        return mText;
    }

    public void setText(String mText){
        this.mText = mText;
    }

    public List<String> getImages(){
        return mImages;
    }

    public void addImages(String img){
        this.mImages.add(img);
    }

    /** 打印文档内容 **/
    public void showDocument(){
        System.out.println("------------------Word Content Start---------------------");
        System.out.println("Text:"+mText);
        System.out.println("Images List:");
        for(String imgName:mImages){
            System.out.println("image name:"+imgName);
        }
        System.out.println("-----------------Word Content End------------------------");
    }
}
