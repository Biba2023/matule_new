package com.example.matule;

import androidx.annotation.DrawableRes;


public class PromoData {
        @DrawableRes
        public  Integer imageId;
        String title;
        String description;
        public  Integer scrollId;


        static PromoData[] values = new PromoData[]{
                new PromoData(R.drawable.img_2, "Quick Delivery At Your Doorstep","Enjoy quick pick-up and delivery to your destination", R.drawable.img_4),
                new PromoData(R.drawable.img_3, "Flexible Payment","Different modes of payment either before and after delivery without stress", R.drawable.img_5)
        };

        public PromoData(int img, String title, String desc, int scroll) {
            this.imageId = img;
            this.title = title;
            this.description = desc;
            this.scrollId = scroll;
        }
    }
