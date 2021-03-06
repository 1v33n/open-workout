package ch.bbcag.openworkout.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Exercise")
public class Exercise {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exerciseId")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    public Exercise(){}
    public Exercise(String name){
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
