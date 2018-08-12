
    // Name: Tran Le
    // AID - 1808
    // File name: Review.java

package com.sunny.android.letran_ce04;

public class Review {

    // Member variables
    private int rName;
    private int rDate;
    private int rAvatar;
    private int rTitle;
    private int rDesc;
    private int rStar;

    // Constructor
    Review(int _rName, int _rDate, int _rAvatar, int _rTitle, int _rDesc, int _rStar) {
        rName = _rName;
        rDate = _rDate;
        rAvatar = _rAvatar;
        rTitle = _rTitle;
        rDesc = _rDesc;
        rStar = _rStar;
    }

    int getName() { return rName; }
    int getDate() { return rDate; }
    int getAvatar() { return rAvatar; }
    int getTitle() { return rTitle; }
    int getDesc() { return rDesc; }
    int getStar() { return rStar; }
}
