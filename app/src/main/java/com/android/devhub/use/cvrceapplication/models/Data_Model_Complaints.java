package com.android.devhub.use.cvrceapplication.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Data_Model_Complaints {

    public String description;
    public int isresolved;
    public int faculty_visibility;
    public int student_visibility;
    public int up_vote;
    public int down_vote;
    public int type;
    public int complaint_id;
    public String date;
    public String name;
    public String email;
    public String title;
    public String reg_id;
    public int priority;
    public int mentor_seen;
    public String positon_seen;

    public Data_Model_Complaints(String description, int isresolved, int faculty_visibility, int
            student_visibility, int up_vote, int down_vote, int type, String date, String name,
                                 String email) {
        this.description = description;
        this.isresolved = isresolved;
        this.faculty_visibility = faculty_visibility;
        this.student_visibility = student_visibility;
        this.up_vote = up_vote;
        this.down_vote = down_vote;
        this.type = type;
        this.date = date;
        this.email = email;
        this.name = name;
    }



    public Data_Model_Complaints(JSONObject object1, JSONObject object2) {

        try {
            //this.title = object1.getString("title");
            int complaint_id1 = object1.getInt("complaint_id");
            Log.i("hagga2", String.valueOf(complaint_id1));
            int isresolved1 = object1.getInt("is_resolved");
            int faculty_visibility1 = object1.getInt("faculty_visibility");
            int student_visibility1 = object1.getInt("student_visibility");
            int upvote=object1.getInt("up_vote");
            int downvote=object1.getInt("down_vote");
            int type=object1.getInt("type");
            int priority = object1.getInt("priority");
            String date= object1.getString("created_at");
            String description = object1.getString("description");
            String name1 = object2.getString("first_name");
            String name = name1.concat(" ").concat(object2.getString("last_name"));
            String email = object2.getString("email");
            String reg_id = object2.getString("REGID");

            this.title = object1.getString("title");
            int mentorSeen = object1.getInt("mentor_seen");
            String positionSeen = object1.getString("position_seen");
            this.complaint_id = complaint_id1;
            this.isresolved = isresolved1;
            this.faculty_visibility = faculty_visibility1;
            this.student_visibility = student_visibility1;
            this.up_vote = upvote;
            this.down_vote = downvote;
            this.type = type;
            this.date = date;
            this.description = description;
            this.name = name;
            this.email = email;
            this.reg_id = reg_id;
            this.priority = priority;
            this.mentor_seen = mentorSeen;
            this.positon_seen = positionSeen;


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public static ArrayList<Data_Model_Complaints> fromJson(JSONArray object1, JSONArray object2) {


        ArrayList<Data_Model_Complaints> gradesData = new ArrayList<>();

        for (int i = 0; i <object1.length()-1; i++) {
            try {
                Log.e("Data Model OBJECT1", "fromJson: " + object1.getJSONObject(object1.length()-i-1));
                Log.e("Data Model OBJECT2", "fromJson: " + object2.getJSONObject(object1.length()-i-1));
                gradesData.add(new Data_Model_Complaints(object1.getJSONObject(object1.length()-i-1),
                        object2.getJSONObject(object1.length()-i-1)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return gradesData;
    }

}