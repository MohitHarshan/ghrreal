package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by reubro on 14/5/18.
 */
@Dao
public interface FollowupDAO {


    @Query("SELECT * FROM followup")
    List<Followup> getAll();

    @Query("SELECT COUNT(*) from followup")
    int countcategories();

    @Query("SELECT COUNT(*) FROM followup where patientno LIKE :patientno")
        int countofpatient(long patientno);

    @Query("SELECT * FROM followup WHERE patientno = :patientno LIMIT (SELECT max(Followupcount) FROM followup WHERE patientno=:patientno)")
    List<Followup> getfollowupofpatient(long patientno);

    @Query("SELECT max(Followupcount) FROM followup WHERE patientno=:patientno")
            int counts(long patientno);

   @Query("SELECT * FROM followup WHERE categoryid =:categoryid")
  List <Followup> getfollowup(int categoryid);


   @Query("SELECT subcategoryvalue FROM followup WHERE (subcategorytitle LIKE :subcategorytitle) AND (Followupcount=:followcount) AND (patientno=:patientno) AND (categoryid=:categoryid )")
   String getvalue(String subcategorytitle,int followcount,long patientno,int categoryid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Followup... followups);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertsingle(Followup followup);


}
