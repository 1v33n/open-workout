package ch.bbcag.openworkout.model;

@Entity(tableName = "myBadi")
public class workout {

    @PrimaryKey
    @ColumnInfo(name = "badId")
    private int id;

    private String date;

}
