package mx.itesm.tacos_de_tinga_19.veintiundias

import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot


class StorageService {

    lateinit var db : FirebaseFirestore

    init {
        var db = FirebaseFirestore.getInstance()
    }

    fun addData(data: Map<String, Object>, collection: String):DocumentReference{

        val documentReference: DocumentReference = Tasks.await(db.collection(collection).add(data))
        return documentReference;
    }

    public fun getData(collection: String) : QuerySnapshot?{
        var document: QuerySnapshot? = Tasks.await(db.collection(collection).get())
        return document;

    }

}