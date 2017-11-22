package mvp.imooc.com.mvpart.utils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import mvp.imooc.com.mvpart.entity.Announcement;
import mvp.imooc.com.mvpart.entity.Contact;
import mvp.imooc.com.mvpart.entity.Meeting;

/**
 * @author:candy
 * @date:2017/11/22 11:35
 * @邮箱:1601796593@qq.com
 */
public class JsoupUtils {
    /**
     * 参会人员列表
     *
     * @param jsonStr json字符串
     * @return 参会人员列表
     */
    public static ArrayList<Contact> parseParticipantsList(String jsonStr) {
        ArrayList<Contact> participants = new ArrayList<>();
        Gson gso = new Gson();
        try {
            JSONArray array = new JSONArray(jsonStr);
            int length = array.length();
            for (int i = 0; i < length; i++) {
                Contact contact = gso.fromJson(array.getJSONObject(i).toString(), Contact.class);
                participants.add(contact);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return participants;
    }

    /**
     * 会议列表
     *
     * @param jsonStr json字符串
     * @return 参会人员列表
     */
    public static ArrayList<Meeting> parseMeetingList(String jsonStr) {
        ArrayList<Meeting> participants = new ArrayList<>();
        Gson gso = new Gson();
        try {
            JSONArray array = new JSONArray(jsonStr);
            int length = array.length();
            for (int i = 0; i < length; i++) {
                participants.add(gso.fromJson(array.getJSONObject(i).toString(), Meeting.class));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return participants;
    }

    /**
     * 我的公告列表
     *
     * @param jsonStr json字符串
     * @re 参会人员列表
     */
    public static ArrayList<Announcement> parseAnnouncementList(String jsonStr) {
        ArrayList<Announcement> participants = new ArrayList<>();
        Gson gso = new Gson();
        try {
            JSONArray array = new JSONArray(jsonStr);
            int length = array.length();
            for (int i = 0; i < length; i++) {
                participants.add(gso.fromJson(array.getJSONObject(i).toString(), Announcement.class));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return participants;
    }


    /***
     * test
     * @param jsonStr
     * @return
     */
    public static <T> ArrayList<T> parseTList(String jsonStr, Class<T> classOfT) {
        ArrayList<T> participants = new ArrayList<>();
        Gson gso = new Gson();
        try {
            JSONArray array = new JSONArray(jsonStr);
            int length = array.length();
            for (int i = 0; i < length; i++) {
                String json=array.getJSONObject(i).toString();
                T item = getT(classOfT, json);
                participants.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return participants;
    }

    public static <T> T getT(Class<T> classOfT, String json) {
        Gson gso = new Gson();
        return gso.fromJson(json, classOfT);
    }
}
