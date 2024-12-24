import android.content.Context
import androidx.core.util.Supplier
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2pam.data.dao.BarangDao
import com.example.ucp2pam.data.dao.SuplierDao
import com.example.ucp2pam.data.model.Barang

@Database(entities = [Barang::class, Supplier::class], version = 1, exportSchema = false)
abstract class GudangDatabase : RoomDatabase() {

    abstract fun barangDao(): BarangDao
    abstract fun supplierDao(): SuplierDao

    companion object {
        @Volatile
        private var Instance: GudangDatabase? = null

        fun getDatabase(context: Context): GudangDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    GudangDatabase::class.java,
                    "GudangDatabase"
                ).build().also { Instance = it }
            }
        }
    }
}