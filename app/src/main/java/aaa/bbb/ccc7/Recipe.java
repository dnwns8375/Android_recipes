package aaa.bbb.ccc7;

public class Recipe {

    private int mainImage;
    private String name;
    private int[] fullText;

    public int[] getAllImg() {
        return allImg;
    }

    private int[] allImg;
    private int ingredients;
    private int calory;
    private String time;

    public int getMainImage() {
        return mainImage;
    }

    public String getName() {
        return name;
    }

    public int[] getFullText() {
        return fullText;
    }

    public int getIngredients() {
        return ingredients;
    }

    public int getCalory() {
        return calory;
    }

    public String getTime() {
        return time;
    }

    public Recipe(int mainImage, int[] allImg, String name, int[] fullText, int ingredients, int calory, String time) {
        this.mainImage = mainImage;
        this.name = name;
        this.fullText = fullText;
        this.allImg = allImg;
        this.ingredients = ingredients;
        this.calory = calory;
        this.time = time;
    }
}
