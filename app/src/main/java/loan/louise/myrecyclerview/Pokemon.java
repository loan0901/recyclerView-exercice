package loan.louise.myrecyclerview;

public class Pokemon {
    private String mImageURL;
    String mText1;
    String mText2;

    public Pokemon(String imageResource, String text1, String text2){
        mImageURL = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    public String getImageResource(){
        return mImageURL;
    }
    public String getText1(){
        return mText1;
    }
    public String getText2(){
        return mText2;
    }
}
