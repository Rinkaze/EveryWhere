package com.jiyun.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jiyun.util.StringConverter;
import java.util.List;

import com.jiyun.bean.StoriesEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STORIES_ENTITY".
*/
public class StoriesEntityDao extends AbstractDao<StoriesEntity, Long> {

    public static final String TABLENAME = "STORIES_ENTITY";

    /**
     * Properties of entity StoriesEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property Images = new Property(1, String.class, "images", false, "IMAGES");
        public final static Property Ga_prefix = new Property(2, String.class, "ga_prefix", false, "GA_PREFIX");
        public final static Property Multipic = new Property(3, boolean.class, "multipic", false, "MULTIPIC");
        public final static Property Id = new Property(4, int.class, "id", false, "ID");
        public final static Property Title = new Property(5, String.class, "title", false, "TITLE");
        public final static Property Type = new Property(6, int.class, "type", false, "TYPE");
    }

    private final StringConverter imagesConverter = new StringConverter();

    public StoriesEntityDao(DaoConfig config) {
        super(config);
    }
    
    public StoriesEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STORIES_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: _id
                "\"IMAGES\" TEXT," + // 1: images
                "\"GA_PREFIX\" TEXT," + // 2: ga_prefix
                "\"MULTIPIC\" INTEGER NOT NULL ," + // 3: multipic
                "\"ID\" INTEGER NOT NULL ," + // 4: id
                "\"TITLE\" TEXT," + // 5: title
                "\"TYPE\" INTEGER NOT NULL );"); // 6: type
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STORIES_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, StoriesEntity entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        List images = entity.getImages();
        if (images != null) {
            stmt.bindString(2, imagesConverter.convertToDatabaseValue(images));
        }
 
        String ga_prefix = entity.getGa_prefix();
        if (ga_prefix != null) {
            stmt.bindString(3, ga_prefix);
        }
        stmt.bindLong(4, entity.getMultipic() ? 1L: 0L);
        stmt.bindLong(5, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(6, title);
        }
        stmt.bindLong(7, entity.getType());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, StoriesEntity entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        List images = entity.getImages();
        if (images != null) {
            stmt.bindString(2, imagesConverter.convertToDatabaseValue(images));
        }
 
        String ga_prefix = entity.getGa_prefix();
        if (ga_prefix != null) {
            stmt.bindString(3, ga_prefix);
        }
        stmt.bindLong(4, entity.getMultipic() ? 1L: 0L);
        stmt.bindLong(5, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(6, title);
        }
        stmt.bindLong(7, entity.getType());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public StoriesEntity readEntity(Cursor cursor, int offset) {
        StoriesEntity entity = new StoriesEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.isNull(offset + 1) ? null : imagesConverter.convertToEntityProperty(cursor.getString(offset + 1)), // images
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // ga_prefix
            cursor.getShort(offset + 3) != 0, // multipic
            cursor.getInt(offset + 4), // id
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // title
            cursor.getInt(offset + 6) // type
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, StoriesEntity entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setImages(cursor.isNull(offset + 1) ? null : imagesConverter.convertToEntityProperty(cursor.getString(offset + 1)));
        entity.setGa_prefix(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMultipic(cursor.getShort(offset + 3) != 0);
        entity.setId(cursor.getInt(offset + 4));
        entity.setTitle(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setType(cursor.getInt(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(StoriesEntity entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(StoriesEntity entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(StoriesEntity entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}