package com.hendev.notes

import android.content.ContentValues

class DbBasicsDao {

    //1- Change dbName
    //2- In ArrayList dbName set as BasicDataClass
    //3- Change Column Names and Data Types
    //4- Change Column Names on Function requirements

    fun tumTablo(vt: VeritabaniYardimcisi): ArrayList<BasicDataClass> {                         // [2]
        val db = vt.writableDatabase
        val arrList = ArrayList<BasicDataClass>()                                               // [2]
        val c = db.rawQuery("SELECT * FROM dbName", null)                      // [1]

        while (c.moveToNext()) {
            val bas = BasicDataClass(                                                           // [2]
                c.getInt(c.getColumnIndex("id")),                                  // [3]
                c.getString(c.getColumnIndex("column1")),                          // [3]
                c.getInt(c.getColumnIndex("column2")),                             // [3]
                c.getInt(c.getColumnIndex("column3"))                              // [3]
            )
            arrList.add(bas)
        }
        return arrList
    }

    fun simpleDelete(vt: VeritabaniYardimcisi, id: Int) {
        val db = vt.writableDatabase
        db.delete("dbName", "id=?", arrayOf(id.toString()))                  // [1]
        db.close()
    }

    fun notEkle(vt: VeritabaniYardimcisi, column1: String, column2: Int, column3: Int) {
        val db = vt.writableDatabase
        val values = ContentValues()
        values.put("column1", column1)                                                          // [3]
        values.put("column2", column2)                                                          // [3]
        values.put("column3", column3)                                                          // [3]

        db.insertOrThrow("dbName", null, values)                          // [1]
        db.close()
    }

    fun notGuncelle(vt: VeritabaniYardimcisi, id:Int, column1: String, column2: Int, column3: Int) {
        val db = vt.writableDatabase
        val values = ContentValues()
        values.put("column1", column1)
        values.put("column2", column2)
        values.put("column3", column3)

        db.update("dbName", values, "id=?", arrayOf(id.toString()))          // [1]
        db.close()
    }
}