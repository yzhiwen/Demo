package com.yangzhiwen.demo

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.widget.Toast

class UserContentProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        println("UserContentProvider delete")
        Toast.makeText(context, "UserContentProvider delete", Toast.LENGTH_SHORT).show()
        return 0
    }

    override fun getType(uri: Uri): String? {
        println("UserContentProvider getType")
        Toast.makeText(context, "UserContentProvider getType", Toast.LENGTH_SHORT).show()
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        println("UserContentProvider insert")
        Toast.makeText(context, "UserContentProvider insert", Toast.LENGTH_SHORT).show()
        return null
    }

    override fun onCreate(): Boolean {
        println("UserContentProvider onCreate")
        Toast.makeText(context, "UserContentProvider onCreate", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?,
                       selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        println("UserContentProvider query")
        Toast.makeText(context, "UserContentProvider query", Toast.LENGTH_SHORT).show()
        return null
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?,
                        selectionArgs: Array<String>?): Int {
        println("UserContentProvider update")
        Toast.makeText(context, "UserContentProvider update", Toast.LENGTH_SHORT).show()
        return 0
    }
}
