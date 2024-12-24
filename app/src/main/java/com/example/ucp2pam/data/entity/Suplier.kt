
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblSupplier")
data class Suplier(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val kontak: String,
    val alamat: String
)