package caresurvey.sci.com.caresurvey.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import caresurvey.sci.com.caresurvey.model.FormItemUser;

/**
 * Created by Shahin on 5/16/2016.
 */
public class InventoryTable {
    public static final String TABLE_NAME = DatabaseHelper.FORM_INVENTORY;
    private Context tContext;
    public static final String inventory_id = "id";
    public static final String facility_id = "facility_id";
    public static final String client_name = "client_name";
    public static final String start_time = "start_time";
    public static final String instrument_sp_name = "instrument_sp_name";
    public static final String instrument_sp_designation = "instrument_sp_designation";
    public static final String i_electronic_autoclev = "i_electronic_autoclev";
    public static final String i_non_electronic_autoclev = "i_non_electronic_autoclev";
    public static final String i_electric_sterilizer = "i_electric_sterilizer";
    public static final String i_electric_steamer = "i_electric_steamer";
    public static final String i_non_electric_pot = "i_non_electric_pot";
    public static final String i_stove = "i_stove";
    public static final String i_waste_sp_name = "i_waste_sp_name";
    public static final String i_waste_sp_designation = "i_waste_sp_designation";
    public static final String w_waste_option = "w_waste_option";
    public static final String w_waste_dispose_how = "w_waste_dispose_how";
    public static final String w_pointy_waste = "w_pointy_waste";
    public static final String w_liquid_waste = "w_liquid_waste";
    public static final String w_liquid_waste_store = "w_liquid_waste_store";
    public static final String w_plastic_waste = "w_plastic_waste";
    public static final String w_waste_normal = "w_waste_normal";
    public static final String w_incinerator_seen = "w_incinerator_seen";
    public static final String w_dumping_pit_seen = "w_dumping_pit_seen";
    public static final String equipment_sp_name = "equipment_sp_name";
    public static final String equipment_sp_designation = "equipment_sp_designation";
    public static final String w_incinerator = "w_incinerator";
    public static final String n_adult_wing_scale = "n_adult_wing_scale";
    public static final String n_height_rod = "n_height_rod";
    public static final String n_pressure_mechine = "n_pressure_mechine";
    public static final String n_stethoscope = "n_stethoscope";
    public static final String n_filter_stethoscope = "n_filter_stethoscope";
    public static final String n_water = "n_water";
    public static final String n_hand_soap = "n_hand_soap";
    public static final String n_spirit = "n_spirit";
    public static final String n_waste = "n_waste";
    public static final String n_sharp_waste = "n_sharp_waste";
    public static final String n_gloves = "n_gloves";
    public static final String n_iron_folate = "n_iron_folate";
    public static final String n_urine_protien = "n_urine_protien";
    public static final String n_urine_tester = "n_urine_tester";
    public static final String n_urine_testtube = "n_urine_testtube";
    public static final String n_test_tube_rack = "n_test_tube_rack";
    public static final String n_dip_stick = "n_dip_stick";
    public static final String n_hemoglobin = "n_hemoglobin";
    public static final String n_telecoil_book = "n_telecoil_book";
    public static final String n_telecoil_landset = "n_telecoil_landset";
    public static final String n_kolori_meter = "n_kolori_meter";
    public static final String n_litmus_paper = "n_litmus_paper";
    public static final String delivery_sp_name = "delivery_sp_name";
    public static final String delivery_sp_designation = "delivery_sp_designation";
    public static final String d_delivery_table = "d_delivery_table";
    public static final String d_pressure_mechine = "d_pressure_mechine";
    public static final String d_stethoscope = "d_stethoscope";
    public static final String d_filter_stethoscope = "d_filter_stethoscope";
    public static final String d_newborn_recuscitation = "d_newborn_recuscitation";
    public static final String d_recuscitation_mask_0 = "d_recuscitation_mask_0";
    public static final String d_recuscitation_mask_1 = "d_recuscitation_mask_1";
    public static final String d_peguin_sucker = "d_peguin_sucker";
    public static final String d_cord_cutter = "d_cord_cutter";
    public static final String d_cord_clamp = "d_cord_clamp";
    public static final String d_partograf_paper = "d_partograf_paper";
    public static final String d_water = "d_water";
    public static final String d_hand_soap = "d_hand_soap";
    public static final String d_spirit = "d_spirit";
    public static final String d_waste_recycle = "d_waste_recycle";
    public static final String d_waste_storage = "d_waste_storage";
    public static final String d_latex_gloves = "d_latex_gloves";
    public static final String d_chlorine_sol = "d_chlorine_sol";
    public static final String d_detergent_water = "d_detergent_water";
    public static final String d_clean_water = "d_clean_water";
    public static final String d_misoprostol = "d_misoprostol";
    public static final String d_oxytocin = "d_oxytocin";
    public static final String d_mang_sulfate = "d_mang_sulfate";
    public static final String d_chlorhexidine = "d_chlorhexidine";
    public static final String d_paediatric_drop = "d_paediatric_drop";
    public static final String d_gentamycin = "d_gentamycin";
    public static final String ch_wing_scale = "ch_wing_scale";
    public static final String ch_infant_wing_scale = "ch_infant_wing_scale";
    public static final String ch_height_rod = "ch_height_rod";
    public static final String ch_measuring_tip = "ch_measuring_tip";
    public static final String ch_water = "ch_water";
    public static final String ch_growth_monitor_boy = "ch_growth_monitor_boy";
    public static final String ch_growth_monitor_girl = "ch_growth_monitor_girl";
    public static final String ch_hand_soap = "ch_hand_soap";
    public static final String ch_spirit = "ch_spirit";
    public static final String ch_wastage_recycle = "ch_wastage_recycle";
    public static final String ch_sharp_waste = "ch_sharp_waste";
    public static final String ch_latex_gloves = "ch_latex_gloves";
    public static final String ch_ors = "ch_ors";
    public static final String ch_paediatric_drop = "ch_paediatric_drop";
    public static final String ch_cotrimoxazole = "ch_cotrimoxazole";
    public static final String ch_paracetamol = "ch_paracetamol";
    public static final String ch_zinc = "ch_zinc";
    public static final String ch_mebandazole = "ch_mebandazole";
    public static final String ch_ceftriaxone = "ch_ceftriaxone";
    public static final String ch_vitamin = "ch_vitamin";
    public static final String fp_soap = "fp_soap";
    public static final String fp_spirit = "fp_spirit";
    public static final String fp_waste_recycle = "fp_waste_recycle";
    public static final String fp_sharp_waste = "fp_sharp_waste";
    public static final String fp_latex_gloves = "fp_latex_gloves";
    public static final String r_healthy_newborn = "r_healthy_newborn";
    public static final String r_newborn_death = "r_newborn_death";
    public static final String r_mother_rate = "r_mother_rate";
    public static final String r_elampsia = "r_elampsia";
    public static final String r_mang_sulfate = "r_mang_sulfate";
    public static final String r_pneumonis = "r_pneumonis";
    public static final String r_paracetamol = "r_paracetamol";
    public static final String r_psbi = "r_psbi";
    public static final String r_psbi_care = "r_psbi_care";
    public static final String r_starving_child = "r_starving_child";
    public static final String r_starving_protocol = "r_starving_protocol";
    public static final String end_time = "end_time";
    public static final String village = "village";
    public static final String district = "district";
    public static final String union = "union";
    public static final String sub_district = "sub_district";

    public void InventoryTable (Context context) {
        tContext = context;
        createTable();
    }

    private void createTable() {
        SQLiteDatabase db = openDB();

        String CREATE_TABLE_SQL = "CREATE TABLE"
                + " "
                + TABLE_NAME
                + " ("
                + InventoryTable.inventory_id
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + InventoryTable.facility_id
                + " TEXT, "
                + InventoryTable.client_name
                + " TEXT, "
                + InventoryTable.start_time
                + " TEXT, "
                + InventoryTable.instrument_sp_name
                + " TEXT, "
                + InventoryTable.instrument_sp_designation
                + " TEXT, "
                + InventoryTable.i_electronic_autoclev
                + " TEXT, "
                + InventoryTable.i_non_electronic_autoclev
                + " TEXT, "
                + InventoryTable.i_electric_sterilizer
                + " TEXT, "
                + InventoryTable.i_electric_steamer
                + " TEXT, "
                + InventoryTable.i_non_electric_pot
                + " TEXT, "
                + InventoryTable.i_stove
                + " TEXT, "
                + InventoryTable.i_waste_sp_name
                + " TEXT, "
                + InventoryTable.i_waste_sp_designation
                + " TEXT, "
                + InventoryTable.w_waste_option
                + " TEXT, "
                + InventoryTable.w_waste_dispose_how
                + " TEXT, "
                + InventoryTable.w_pointy_waste
                + " TEXT, "
                + InventoryTable.w_liquid_waste
                + " TEXT, "
                + InventoryTable.w_liquid_waste_store
                + " TEXT, "
                + InventoryTable.w_plastic_waste
                + " TEXT, "
                + InventoryTable.w_waste_normal
                + " TEXT, "
                + InventoryTable.w_incinerator_seen
                + " TEXT, "
                + InventoryTable.w_dumping_pit_seen
                + " TEXT, "
                + InventoryTable.equipment_sp_name
                + " TEXT, "
                + InventoryTable.equipment_sp_designation
                + " TEXT, "
                + InventoryTable.w_incinerator
                + " TEXT, "
                + InventoryTable.n_adult_wing_scale
                + " TEXT, "
                + InventoryTable.n_height_rod
                + " TEXT, "
                + InventoryTable.n_pressure_mechine
                + " TEXT, "
                + InventoryTable.n_stethoscope
                + " TEXT, "
                + InventoryTable.n_filter_stethoscope
                + " TEXT, "
                + InventoryTable.n_water
                + " TEXT, "
                + InventoryTable.n_hand_soap
                + " TEXT, "
                + InventoryTable.n_spirit
                + " TEXT, "
                + InventoryTable.n_waste
                + " TEXT, "
                + InventoryTable.n_sharp_waste
                + " TEXT, "
                + InventoryTable.n_gloves
                + " TEXT, "
                + InventoryTable.n_iron_folate
                + " TEXT, "
                + InventoryTable.n_urine_protien
                + " TEXT, "
                + InventoryTable.n_urine_tester
                + " TEXT, "
                + InventoryTable.n_urine_testtube
                + " TEXT, "
                + InventoryTable.n_test_tube_rack
                + " TEXT, "
                + InventoryTable.n_dip_stick
                + " TEXT, "
                + InventoryTable.n_hemoglobin
                + " TEXT, "
                + InventoryTable.n_telecoil_book
                + " TEXT, "
                + InventoryTable.n_telecoil_landset
                + " TEXT, "
                + InventoryTable.n_kolori_meter
                + " TEXT, "
                + InventoryTable.n_litmus_paper
                + " TEXT, "
                + InventoryTable.delivery_sp_name
                + " TEXT, "
                + InventoryTable.delivery_sp_designation
                + " TEXT, "
                + InventoryTable.d_delivery_table
                + " TEXT, "
                + InventoryTable.d_pressure_mechine
                + " TEXT, "
                + InventoryTable.d_stethoscope
                + " TEXT, "
                + InventoryTable.d_filter_stethoscope
                + " TEXT, "
                + InventoryTable.d_newborn_recuscitation
                + " TEXT, "
                + InventoryTable.d_recuscitation_mask_0
                + " TEXT, "
                + InventoryTable.d_recuscitation_mask_1
                + " TEXT, "
                + InventoryTable.d_peguin_sucker
                + " TEXT, "
                + InventoryTable.d_cord_cutter
                + " TEXT, "
                + InventoryTable.d_cord_clamp
                + " TEXT, "
                + InventoryTable.d_partograf_paper
                + " TEXT, "
                + InventoryTable.d_water
                + " TEXT, "
                + InventoryTable.d_hand_soap
                + " TEXT, "
                + InventoryTable.d_spirit
                + " TEXT, "
                + InventoryTable.d_waste_recycle
                + " TEXT, "
                + InventoryTable.d_waste_storage
                + " TEXT, "
                + InventoryTable.d_latex_gloves
                + " TEXT, "
                + InventoryTable.d_chlorine_sol
                + " TEXT, "
                + InventoryTable.d_detergent_water
                + " TEXT, "
                + InventoryTable.d_clean_water
                + " TEXT, "
                + InventoryTable.d_misoprostol
                + " TEXT, "
                + InventoryTable.d_oxytocin
                + " TEXT, "
                + InventoryTable.d_mang_sulfate
                + " TEXT, "
                + InventoryTable.d_chlorhexidine
                + " TEXT, "
                + InventoryTable.d_paediatric_drop
                + " TEXT, "
                + InventoryTable.d_gentamycin
                + " TEXT, "
                + InventoryTable.ch_wing_scale
                + " TEXT, "
                + InventoryTable.ch_infant_wing_scale
                + " TEXT, "
                + InventoryTable.ch_height_rod
                + " TEXT, "
                + InventoryTable.ch_measuring_tip
                + " TEXT, "
                + InventoryTable.ch_water
                + " TEXT, "
                + InventoryTable.ch_growth_monitor_boy
                + " TEXT, "
                + InventoryTable.ch_growth_monitor_girl
                + " TEXT, "
                + InventoryTable.ch_hand_soap
                + " TEXT, "
                + InventoryTable.ch_spirit
                + " TEXT, "
                + InventoryTable.ch_wastage_recycle
                + " TEXT, "
                + InventoryTable.ch_sharp_waste
                + " TEXT, "
                + InventoryTable.ch_latex_gloves
                + " TEXT, "
                + InventoryTable.ch_ors
                + " TEXT, "
                + InventoryTable.ch_paediatric_drop
                + " TEXT, "
                + InventoryTable.ch_cotrimoxazole
                + " TEXT, "
                + InventoryTable.ch_paracetamol
                + " TEXT, "
                + InventoryTable.ch_zinc
                + " TEXT, "
                + InventoryTable.ch_mebandazole
                + " TEXT, "
                + InventoryTable.ch_ceftriaxone
                + " TEXT, "
                + InventoryTable.ch_vitamin
                + " TEXT, "
                + InventoryTable.fp_soap
                + " TEXT, "
                + InventoryTable.fp_spirit
                + " TEXT, "
                + InventoryTable.fp_waste_recycle
                + " TEXT, "
                + InventoryTable.fp_sharp_waste
                + " TEXT, "
                + InventoryTable.fp_latex_gloves
                + " TEXT, "
                + InventoryTable.r_healthy_newborn
                + " TEXT, "
                + InventoryTable.r_newborn_death
                + " TEXT, "
                + InventoryTable.r_mother_rate
                + " TEXT, "
                + InventoryTable.r_elampsia
                + " TEXT, "
                + InventoryTable.r_mang_sulfate
                + " TEXT, "
                + InventoryTable.r_pneumonis
                + " TEXT, "
                + InventoryTable.r_paracetamol
                + " TEXT, "
                + InventoryTable.r_psbi
                + " TEXT, "
                + InventoryTable.r_psbi_care
                + " TEXT, "
                + InventoryTable.r_starving_child
                + " TEXT, "
                + InventoryTable.r_starving_protocol
                + " TEXT, "
                + InventoryTable.end_time
                + " TEXT, "
                + InventoryTable.village
                + " TEXT, "
                + InventoryTable.district
                + " TEXT, "
                + InventoryTable.union
                + " TEXT, "
                + InventoryTable.sub_district
                + " TEXT);";
        db.execSQL(CREATE_TABLE_SQL);
        closeDB();
    }

    private SQLiteDatabase openDB() {
        return DatabaseManager.getInstance(tContext).openDatabase();
    }

    private void closeDB() {
        DatabaseManager.getInstance(tContext).closeDatabase();
    }

    public long insertItem(FormItemUser formItem) {
        return insertItem(formItem.getPatientid(),formItem.getBloodpressure(),formItem.getHemoglobintest(),
                formItem.getUrinetest(),formItem.getPregnancyfood(),formItem.getPregnancydanger(),formItem.getFourparts(),
                formItem.getDelivery(),formItem.getFeedbaby(),formItem.getSixmonths(),formItem.getFamilyplanning(),formItem.getFolictablet(),
                formItem.getFolictabletimportance(),formItem.getStatus(),formItem.getGlobal_id(),formItem.getName(),formItem.getComments(),formItem.getFields(),formItem.getInS(),formItem.getDatepick(),formItem.getTimepick(),formItem.getCollector_name(),formItem.getDivision(),formItem.getUpozila(),formItem.getUnion(),formItem.getVillage(),formItem.getObs_type());
    }
    public long insertItem(int patientid, String bloodpressure, String hemoglobintest,
                           String urinetest, String pregnancyfood, String pregnancydanger,
                           String fourparts, String delivery, String feedbaby,
                           String sixmonths, String familyplanning, String folictablet,
                           String folictabletimportance, int status, String globalId, String name,String comments, String fields, String inS, String datepick,String timepick,String collector_name, String division, String upozila, String union, String village, String obstype) {
        if (isFieldExist(patientid)) {
            return updateItem(patientid,bloodpressure, hemoglobintest,
                    urinetest, pregnancyfood, pregnancydanger,
                    fourparts, delivery,feedbaby,
                    sixmonths, familyplanning,folictablet, folictabletimportance,status,globalId,name,comments,fields,inS,datepick,timepick,collector_name,division,upozila,union,village,obstype);
        }
        SQLiteDatabase db = openDB();
        long ret= db.insert(TABLE_NAME, null, getValues());
        closeDB();
        return ret;
    }

    private ContentValues getValues() {

        ContentValues values = new ContentValues();
//        values.put(KEY_ID, patientid);
//        values.put(KEY_BLOOD, bloodpressure);
//        values.put(KEY_HEMO, hemoglobintest);
//        values.put(KEY_URINE, urinetest);
//        values.put(KEY_PREGFOOD, pregnancyfood);
//        values.put(KEY_PREGDANGER, pregnancydanger);
//        values.put(KEY_FOURCENTER, fourparts);
//        values.put(KEY_DELIVERY, delivery);
//        values.put(KEY_FEED, feedbaby);
//        values.put(KEY_SIXMONTHS, sixmonths);
//        values.put(KEY_FAMILY, familyplanning);
//        values.put(KEY_FOLICTAB, folictablet);
//        values.put(KEY_FOLICIMP, folictabletimportance);
//        values.put(KEY_STATUS, status);
//        values.put(KEY_GLOBAL_ID, globalId);
//        values.put(KEY_NAME, name);
//        values.put(KEY_COMMENT, comments);
//        values.put(KEY_FIELDS, fields);
//        values.put(KEY_INS, inS);
//        values.put(KEY_DATE_PICK,datepick);
//        values.put(KEY_TIME_PICK, timepick);
//        values.put(KEY_COLLECTOR_NAME, collector_name);
//        values.put(KEY_DIVISION, division);
//        values.put(KEY_UPOZILA, upozila);
//        values.put(KEY_UNION, union);
//        values.put(KEY_VILLAGE, village);
//        values.put(KEY_OBSTYPE, obstype);

        return values;
    }

    public long updateItem(int patientid, String bloodpressure, String hemoglobintest,
                           String urinetest, String pregnancyfood, String pregnancydanger,
                           String fourparts, String delivery, String feedbaby,
                           String sixmonths, String familyplanning, String folictablet,
                           String folictabletimportance,int status, String globalId, String name, String comments, String fields, String inS, String datepick, String timepick, String collector_name, String division, String upozila, String union, String village, String obstype) {

        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, getValues(), inventory_id + " = ?",
                new String[]{patientid + ""});
        closeDB();
        return ret;
    }

    public boolean isFieldExist(int id) {
        //Lg.d(TAG, "isFieldExist : inside, id=" + id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                if (Integer.parseInt(cursor.getString(0)) ==id) {
                    cursor.close();
                    closeDB();
                    return true;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return false;
    }
}
