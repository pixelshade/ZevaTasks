package pixelshade.zevatasks.tasks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
* Created by pixelshade on 1.4.2015.
*/
public class DatabaseHelper{}
//        extends SQLiteOpenHelper {

    // Logcat tag
//    private static final String LOG = DatabaseHelper.class.getName();
//
//    // Database Version
//    private static final int DATABASE_VERSION = 1;
//
//    // Database Name
//    private static final String DATABASE_NAME = "contactsManager";
//
//    // Table Names
//    private static final String TABLE_PROJECT = "projects";
//    private static final String TABLE_TODO = "tasks";
//    private static final String TABLE_TAG = "tags";
//    private static final String TABLE_TODO_TAG = "task_tags";
//
//    // Common column names
//    private static final String KEY_ID = "id";
//    private static final String KEY_CREATED_AT = "created_at";
//    private static final String KEY_COMPLETED_AT = "completed_at";
//    private static final String KEY_STATUS = "status";
//
//    // PROJECT table - column names
//    private static final String KEY_PROJECT_NAME = "project_name";
//
//    // NOTES Table - column nmaes
//    private static final String KEY_TODO_NAME = "task";
//    private static final String KEY_TIME_SPENT = "time_spent";
//    private static final String KEY_PROJECT_ID = "project_id";
//
//
//    // TAGS Table - column names
//    private static final String KEY_TAG_NAME = "tag_name";
//
//    // NOTE_TAGS Table - column names
//    private static final String KEY_TODO_ID = "task_id";
//    private static final String KEY_TAG_ID = "tag_id";
//
//    // Table Create Statements
//
//    // projects table create statement
//    private static final String CREATE_TABLE_PROJECT = "CREATE TABLE "
//            + TABLE_PROJECT + "(" + KEY_ID + " INTEGER PRIMARY KEY,"+ KEY_PROJECT_NAME
//            + " TEXT," + KEY_STATUS + " INTEGER," + KEY_COMPLETED_AT
//            + " DATETIME"  + KEY_CREATED_AT
//            + " DATETIME" + ")";
//
//
//    // tasks table create statement
//    private static final String CREATE_TABLE_TODO = "CREATE TABLE "
//            + TABLE_TODO + "("
//            + KEY_ID + " INTEGER PRIMARY KEY,"
//            + KEY_TIME_SPENT + " INTEGER,"
//            + KEY_PROJECT_ID + " INTEGER"
//            + KEY_TODO_NAME + " TEXT,"
//            + KEY_STATUS + " INTEGER,"
//            + KEY_CREATED_AT + " DATETIME" + ")";
//
//    // Tag table create statement
//    private static final String CREATE_TABLE_TAG = "CREATE TABLE " + TABLE_TAG
//            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TAG_NAME + " TEXT,"
//            + KEY_CREATED_AT + " DATETIME" + ")";
//
//    // task_tag table create statement
//    private static final String CREATE_TABLE_TODO_TAG = "CREATE TABLE "
//            + TABLE_TODO_TAG + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
//            + KEY_TODO_ID + " INTEGER," + KEY_TAG_ID + " INTEGER,"
//            + KEY_CREATED_AT + " DATETIME" + ")";
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//        // creating required tables
//        db.execSQL(CREATE_TABLE_PROJECT);
//        db.execSQL(CREATE_TABLE_TODO);
//        db.execSQL(CREATE_TABLE_TAG);
//        db.execSQL(CREATE_TABLE_TODO_TAG);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // on upgrade drop older tables
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECT);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAG);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO_TAG);
//
//        // create new tables
//        onCreate(db);
//    }
//
//    // ------------------------ "projects" table methods ----------------//
//
//    /**
//     * Creating a task
//     */
//    public long createProject(Project project, long[] tasks_ids) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_PROJECT_NAME, project.getName());
//        values.put(KEY_TIME_SPENT, project.getTimeSpent());
//        values.put(KEY_STATUS, project.getStatus());
//        values.put(KEY_COMPLETED_AT, project.getCompletedAt());
//        values.put(KEY_CREATED_AT, getDateTime());
//
//        // insert row
//        long proj_id = db.insert(TABLE_PROJECT, null, values);
//
//        // insert tasks
//        for (long task_id : tasks_ids) {
//            // todo create premade task
////            createToDo();
//        }
//
//        return proj_id;
//    }
//
//    /**
//     * get single task
//     */
//    public Project getProject(long project_id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_PROJECT + " WHERE "
//                + KEY_ID + " = " + project_id;
//
//        Log.e(LOG, selectQuery);
//
//        Cursor c = db.rawQuery(selectQuery, null);
//
//        if (c != null)
//            c.moveToFirst();
//
//        Project p = GetProjectFromCursor(c);
//
//        return p;
//    }
//
//    private Project GetProjectFromCursor(Cursor c){
//        Project p = new Project();
//        p.setId(c.getInt(c.getColumnIndex(KEY_ID)));
//        p.setNote((c.getString(c.getColumnIndex(KEY_TODO_NAME))));
//        p.setStatus((c.getInt(c.getColumnIndex(KEY_STATUS))));
//        p.setTimeSpent((c.getInt(c.getColumnIndex(KEY_TIME_SPENT))));
//        p.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));
//        p.setCompletedAt(c.getString(c.getColumnIndex(KEY_COMPLETED_AT)));
//        return p;
//    }
//
//    /**
//     * getting projects count
//     */
//    public int getProjectsCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_PROJECT;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//
//        int count = cursor.getCount();
//        cursor.close();
//        return count;
//    }
//
//    /**
//     * Updating a project
//     */
//    public int updateProject(Project project) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_TODO_NAME, project.getName());
//        values.put(KEY_COMPLETED_AT, project.getCompletedAt());
//        values.put(KEY_STATUS, project.getStatus());
//        values.put(KEY_TIME_SPENT, project.getTimeSpent());
//
//        // updating row
//        return db.update(TABLE_PROJECT, values, KEY_ID + " = ?",
//                new String[]{String.valueOf(project.getId())});
//    }
//
//    /**
//     * Deleting a project
//     */
//    public void deleteProject(long project_id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_PROJECT, KEY_ID + " = ?",
//                new String[]{String.valueOf(project_id)});
//    }
//
//
//    // ------------------------ "tasks" table methods ----------------//
//
//    /**
//     * Creating a task
//     */
//    public long createToDo(Task task, long[] tag_ids) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_TODO_NAME, task.getNote());
//        values.put(KEY_TIME_SPENT, task.getTimeSpent());
//        values.put(KEY_STATUS, task.getStatus());
//        values.put(KEY_PROJECT_ID, task.getProjectId());
//        values.put(KEY_CREATED_AT, getDateTime());
//
//        // insert row
//        long task_id = db.insert(TABLE_TODO, null, values);
//
//        // insert tag_ids
//        for (long tag_id : tag_ids) {
//            createTaskTag(task_id, tag_id);
//        }
//
//        return task_id;
//    }
//
//    /**
//     * get single task
//     */
//    public Task getTask(long task_id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_TODO + " WHERE "
//                + KEY_ID + " = " + task_id;
//
//        Log.e(LOG, selectQuery);
//
//        Cursor c = db.rawQuery(selectQuery, null);
//
//        if (c != null)
//            c.moveToFirst();
//
//        Task td = GetTaskFromCursor(c);
//
//        return td;
//    }
//
//    private Task GetTaskFromCursor(Cursor c){
//        Task td = new Task();
//        td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
//        td.setNote((c.getString(c.getColumnIndex(KEY_TODO_NAME))));
//        td.setProjectId((c.getInt(c.getColumnIndex(KEY_PROJECT_ID))));
//        td.setStatus((c.getInt(c.getColumnIndex(KEY_STATUS))));
//        td.setStatus((c.getInt(c.getColumnIndex(KEY_TIME_SPENT))));
//        td.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));
//        return td;
//    }
//
//    /**
//     * getting all tasks
//     */
//    public List<Task> getAllProjectToDos(int projectId) {
//        List<Task> tasks = new ArrayList<Task>();
//        String selectQuery = "SELECT  * FROM " + TABLE_TODO + " WHERE "+KEY_PROJECT_ID+ " = "+projectId;
//
//        Log.e(LOG, selectQuery);
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (c.moveToFirst()) {
//            do {
//                Task td = GetTaskFromCursor(c);
//
//                // adding to task list
//                tasks.add(td);
//            } while (c.moveToNext());
//        }
//
//        return tasks;
//    }
//
//    /**
//     * getting all tasks under single tag
//     */
//    public List<Task> getAllToDosByTag(String tag_name) {
//        List<Task> tasks = new ArrayList<Task>();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_TODO + " td, "
//                + TABLE_TAG + " tg, " + TABLE_TODO_TAG + " tt WHERE tg."
//                + KEY_TAG_NAME + " = '" + tag_name + "'" + " AND tg." + KEY_ID
//                + " = " + "tt." + KEY_TAG_ID + " AND td." + KEY_ID + " = "
//                + "tt." + KEY_TODO_ID;
//
//        Log.e(LOG, selectQuery);
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (c.moveToFirst()) {
//            do {
//                Task td = new Task();
//                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
//                td.setNote((c.getString(c.getColumnIndex(KEY_TODO_NAME))));
//                td.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));
//
//                // adding to task list
//                tasks.add(td);
//            } while (c.moveToNext());
//        }
//
//        return tasks;
//    }
//
//    /**
//     * getting tasks count
//     */
//    public int getToDoCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_TODO;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//
//        int count = cursor.getCount();
//        cursor.close();
//
//        // return count
//        return count;
//    }
//
//    /**
//     * Updating a tasks
//     */
//    public int updateToDo(Task task) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_TODO_NAME, task.getNote());
//        values.put(KEY_STATUS, task.getStatus());
//        values.put(KEY_TIME_SPENT, task.getTimeSpent());
//
//        // updating row
//        return db.update(TABLE_TODO, values, KEY_ID + " = ?",
//                new String[]{String.valueOf(task.getId())});
//    }
//
//    /**
//     * Deleting a task
//     */
//    public void deleteToDo(long tado_id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_TODO, KEY_ID + " = ?",
//                new String[]{String.valueOf(tado_id)});
//    }
//
//    // ------------------------ "tags" table methods ----------------//
//
//    /**
//     * Creating tag
//     */
//    public long createTag(Tag tag) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_TAG_NAME, tag.getTagName());
//        values.put(KEY_CREATED_AT, getDateTime());
//
//        // insert row
//        long tag_id = db.insert(TABLE_TAG, null, values);
//
//        return tag_id;
//    }
//
//    /**
//     * getting all tags
//     */
//    public List<Tag> getAllTags() {
//        List<Tag> tags = new ArrayList<Tag>();
//        String selectQuery = "SELECT  * FROM " + TABLE_TAG;
//
//        Log.e(LOG, selectQuery);
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (c.moveToFirst()) {
//            do {
//                Tag t = new Tag();
//                t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
//                t.setTagName(c.getString(c.getColumnIndex(KEY_TAG_NAME)));
//
//                // adding to tags list
//                tags.add(t);
//            } while (c.moveToNext());
//        }
//        return tags;
//    }
//
//    /**
//     * Updating a tag
//     */
//    public int updateTag(Tag tag) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_TAG_NAME, tag.getTagName());
//
//        // updating row
//        return db.update(TABLE_TAG, values, KEY_ID + " = ?",
//                new String[]{String.valueOf(tag.getId())});
//    }
//
//    /**
//     * Deleting a tag
//     */
//    public void deleteTag(Tag tag, boolean should_delete_all_tag_tasks) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        // before deleting tag
//        // check if tasks under this tag should also be deleted
//        if (should_delete_all_tag_tasks) {
//            // get all tasks under this tag
//            List<Task> allTagToDos = getAllToDosByTag(tag.getTagName());
//
//            // delete all tasks
//            for (Task task : allTagToDos) {
//                // delete task
//                deleteToDo(task.getId());
//            }
//        }
//
//        // now delete the tag
//        db.delete(TABLE_TAG, KEY_ID + " = ?",
//                new String[]{String.valueOf(tag.getId())});
//    }
//
//    // ------------------------ "task_tags" table methods ----------------//
//
//    /**
//     * Creating task_tag
//     */
//    public long createTaskTag(long task_id, long tag_id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_TODO_ID, task_id);
//        values.put(KEY_TAG_ID, tag_id);
//        values.put(KEY_CREATED_AT, getDateTime());
//
//        long id = db.insert(TABLE_TODO_TAG, null, values);
//
//        return id;
//    }
//
//    /**
//     * Updating a task tag
//     */
//    public int updateNoteTag(long id, long tag_id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_TAG_ID, tag_id);
//
//        // updating row
//        return db.update(TABLE_TODO, values, KEY_ID + " = ?",
//                new String[]{String.valueOf(id)});
//    }
//
//    /**
//     * Deleting a task tag
//     */
//    public void deleteToDoTag(long id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_TODO, KEY_ID + " = ?",
//                new String[]{String.valueOf(id)});
//    }
//
//    // closing database
//    public void closeDB() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        if (db != null && db.isOpen())
//            db.close();
//    }
//
//    /**
//     * get datetime
//     */
//    private String getDateTime() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(
//                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//        Date date = new Date();
//        return dateFormat.format(date);
//    }
//}