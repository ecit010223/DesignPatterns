package com.year2018.pattern.prototype;

/**
 * author：zyh
 * on: 2018/7/31 21:51
 */
public class Client {
    public static void main(String[] args){
        //1.构建文档对象
        WordDocument originDoc = new WordDocument();
        //2.编辑文档，添加图片等
        originDoc.setText("这是一篇文档");
        originDoc.addImages("picture 1");
        originDoc.addImages("picture 2");
        originDoc.addImages("picture 3");
        originDoc.showDocument();

        //以原始文档为原理，拷贝一份副本
        WordDocument doc2 = null;
        try {
            doc2 = originDoc.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        doc2.showDocument();
        //修改文档副本，不会影响原始文档
        doc2.setText("这是修改过的Doc2文本");
        doc2.showDocument();

        originDoc.showDocument();
    }
}
