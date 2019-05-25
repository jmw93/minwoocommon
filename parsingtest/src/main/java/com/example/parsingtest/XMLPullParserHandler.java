package com.example.parsingtest;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class XMLPullParserHandler {
    public ArrayList<Tour> tourlist = new ArrayList<>();
    public Tour tour;


    public ArrayList<Tour> gettourlist() {
        return tourlist;

    }

    public ArrayList<Tour> parsing() {

        String urlrequest ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=RjzMYQORqJIq4l9YZkCCmV5mTIec%2BdJYC%2BUzK3c2Aogy4I2Y0tZnRI4292OO56Qqr%2FIMajYNHjo5M8Ayz4R05g%3D%3D&contentTypeId=12&areaCode=1&sigunguCode=&cat1=A01&cat2=A0101&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=10";
        try {
            URL url = new URL(urlrequest);
            InputStream is = url.openStream();
            XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = parserFactory.newPullParser();
            xpp.setInput(new InputStreamReader(is,"UTF-8"));

            int eventType = xpp.getEventType();

            //핵심
            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        String startTag = xpp.getName();
                        Log.d("minwoo",startTag);

                        if(startTag.equals("item")){
                        tour = new Tour();

                        }

                        if(startTag.equals("addr1")){
                            xpp.next();
                            tour.setAddress(xpp.getText());

                        }
                        if(startTag.equals("title")){
                            xpp.next();
                         tour.setName(xpp.getText());
                        }



                       break;

                    case XmlPullParser.END_TAG:
                        String endTag =xpp.getName();
                        if(endTag.equals("item")){
                            tourlist.add(tour);

                        }
                        break;

                }//switch문의 끝
                eventType = xpp.next();
            }//for문 끝

        } //try문의 끝
        catch (Exception e){
            Log.e("jmw93",e.toString()+"파싱중오류");
        }

        Log.d("jmw93","파싱성공");
        return tourlist;
    }
}