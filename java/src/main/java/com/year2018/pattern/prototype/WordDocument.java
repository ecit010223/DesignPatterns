package com.year2018.pattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * author：zyh
 * on: 2018/7/31 21:42
 * 浅拷贝
 * 拷贝后的对象中是引用了原对象中mImages的地址，两者指向同一地址，改其一，两者都改
 */
public class WordDocument implements Cloneable {
    /** 文本 **/
    private String mText;
    /** 图片名列表 **/
    private ArrayList<String> mImages = new ArrayList<>();

    public WordDocument(){
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
    protected WordDocument clone() throws CloneNotSupportedException {
        try{
            WordDocument doc = (WordDocument)super.clone();
            doc.mText = this.mText;
            doc.mImages = this.mImages;
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
