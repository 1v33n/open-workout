package ch.bbcag.openworkout.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Exercise")
public class Exercise {

    @PrimaryKey
    @ColumnInfo(name = "exerciseId")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    public Exercise(){}
}
