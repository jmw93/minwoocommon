package com.example.xmlpullparsing;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class XMLPullParserHandler {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Employee employee;
    private String text;

    public ArrayList<Employee> getEmployees() {
        return employees;

    }

    public ArrayList<Employee> parse(InputStream is) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();

            parser.setInput(new InputStreamReader(is, "UTF-8"));

            int eventType = parser.getEventType();


            //핵심
            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        String StartTag = parser.getName();
                        Log.d("dataset",StartTag);

                        if(StartTag.equals("employee")) {
                           employee = new Employee();

                       }

                        if(StartTag.equals("name")){
                            employee.setName(parser.nextText());
                        }
                        if(StartTag.equals("id")){
                            employee.setId(parser.nextText());
                        }
                        if(StartTag.equals("salary")){
                            employee.setSalary(parser.nextText());
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        String endTag = parser.getName();
                        if(endTag.equals("employee")){
                            employees.add(employee);
                        }
                        break;

                }//switch문의 끝
                eventType = parser.next();
            }//for문 끝

        } //try문의 끝
        catch (Exception e){
            Log.e("MyTAG",e.toString());
        }
        Log.e("MyTAG","파싱데이터 모두 읽음");

        return employees;
    }
}
