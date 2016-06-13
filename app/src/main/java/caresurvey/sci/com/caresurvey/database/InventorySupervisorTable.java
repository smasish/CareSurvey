package caresurvey.sci.com.caresurvey.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import caresurvey.sci.com.caresurvey.model.DBRow;
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;
import caresurvey.sci.com.caresurvey.model.InventoryItem;

/**
 * Created by shantanu on 6/13/16.
 */

public class InventorySupervisorTable extends SuperTable{
    private static final String KEY_ID= "_id";
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
    public static final String w_dumping_pit = "w_dumping_pit";
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
    public static final String d_delivery_service = "d_delivery_service";
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
    public static final String union = "_union";
    public static final String sub_district = "sub_district";

    private static final String KEY_USER_ID = "_user_id";
    private static final String KEY_COMMENTS="_comments";
    private static final String KEY_FIELDS="_fields";
    private static final String KEY_META="_meta";
    private static final String KEY_SUBMITTED_BY="_submitted_by";
    private static final String KEY_FORM_TYPE = "_form_type";
    public static final String TABLE_NAME = DatabaseHelper.FORM_INVENTORY_SUPERVISOR;
    public InventorySupervisorTable(Context context) {
        super(context, TABLE_NAME);
    }

    @Override
    protected void createTable() {
        try {
            List<String> tableQuery = getCreateTableQuery();
            SQLiteDatabase db = openDB();
            for(int i=0;i<tableQuery.size();i++)
            {
                db.execSQL(tableQuery.get(i));
            }
            Log.e("inv_supervisor table:","created");
            closeDB();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void generateTable() {
        Hashtable<String,String> table = new Hashtable<String,String>();
        table.put(KEY_ID, "integer primary key"); //must need to  add this key//supervisor field
        table.put(InventoryTable.facility_id
                ," TEXT");
                table.put(InventoryTable.client_name
                ," TEXT");
                table.put(InventoryTable.start_time
                ," TEXT");
                table.put(InventoryTable.instrument_sp_name
                ," TEXT");
                table.put(InventoryTable.instrument_sp_designation
                ," TEXT");
                table.put(InventoryTable.i_electronic_autoclev
                ," TEXT");
                table.put(InventoryTable.i_non_electronic_autoclev
                ," TEXT");
                table.put(InventoryTable.i_electric_sterilizer
                ," TEXT");
                table.put(InventoryTable.i_electric_steamer
                ," TEXT");
                table.put(InventoryTable.i_non_electric_pot
                ," TEXT");
                table.put(InventoryTable.i_stove
                ," TEXT");
                table.put(InventoryTable.i_waste_sp_name
                ," TEXT");
                table.put(InventoryTable.i_waste_sp_designation
                ," TEXT");
                table.put(InventoryTable.w_waste_option
                ," TEXT");
                table.put(InventoryTable.w_waste_dispose_how
                ," TEXT");
                table.put(InventoryTable.w_pointy_waste
                ," TEXT");
                table.put(InventoryTable.w_liquid_waste
                ," TEXT");
                table.put(InventoryTable.w_liquid_waste_store
                ," TEXT");
                table.put(InventoryTable.w_plastic_waste
                ," TEXT");
                table.put(InventoryTable.w_waste_normal
                ," TEXT");
                table.put(InventoryTable.w_incinerator_seen
                ," TEXT");
                table.put(InventoryTable.w_dumping_pit_seen
                ," TEXT");
                table.put(InventoryTable.equipment_sp_name
                ," TEXT");
                table.put(InventoryTable.equipment_sp_designation
                ," TEXT");
                table.put(InventoryTable.w_incinerator
                ," TEXT");
                table.put(InventoryTable.w_dumping_pit
                ," TEXT");
                table.put(InventoryTable.n_adult_wing_scale
                ," TEXT");
                table.put(InventoryTable.n_height_rod
                ," TEXT");
                table.put(InventoryTable.n_pressure_mechine
                ," TEXT");
                table.put(InventoryTable.n_stethoscope
                ," TEXT");
                table.put(InventoryTable.n_filter_stethoscope
                ," TEXT");
                table.put(InventoryTable.n_water
                ," TEXT");
                table.put(InventoryTable.n_hand_soap
                ," TEXT");
                table.put(InventoryTable.n_spirit
                ," TEXT");
                table.put(InventoryTable.n_waste
                ," TEXT");
                table.put(InventoryTable.n_sharp_waste
                ," TEXT");
                table.put(InventoryTable.n_gloves
                ," TEXT");
                table.put(InventoryTable.n_iron_folate
                ," TEXT");
                table.put(InventoryTable.n_urine_protien
                ," TEXT");
                table.put(InventoryTable.n_urine_tester
                ," TEXT");
                table.put(InventoryTable.n_urine_testtube
                ," TEXT");
                table.put(InventoryTable.n_test_tube_rack
                ," TEXT");
                table.put(InventoryTable.n_dip_stick
                ," TEXT");
                table.put(InventoryTable.n_hemoglobin
                ," TEXT");
                table.put(InventoryTable.n_telecoil_book
                ," TEXT");
                table.put(InventoryTable.n_telecoil_landset
                ," TEXT");
                table.put(InventoryTable.n_kolori_meter
                ," TEXT");
                table.put(InventoryTable.n_litmus_paper
                ," TEXT");
                table.put(InventoryTable.delivery_sp_name
                ," TEXT");
                table.put(InventoryTable.delivery_sp_designation
                ," TEXT");
                table.put(InventoryTable.d_delivery_service
                ," TEXT");
                table.put(InventoryTable.d_delivery_table
                ," TEXT");
                table.put(InventoryTable.d_pressure_mechine
                ," TEXT");
                table.put(InventoryTable.d_stethoscope
                ," TEXT");
                table.put(InventoryTable.d_filter_stethoscope
                ," TEXT");
                table.put(InventoryTable.d_newborn_recuscitation
                ," TEXT");
                table.put(InventoryTable.d_recuscitation_mask_0
                ," TEXT");
                table.put(InventoryTable.d_recuscitation_mask_1
                ," TEXT");
                table.put(InventoryTable.d_peguin_sucker
                ," TEXT");
                table.put(InventoryTable.d_cord_cutter
                ," TEXT");
                table.put(InventoryTable.d_cord_clamp
                ," TEXT");
                table.put(InventoryTable.d_partograf_paper
                ," TEXT");
                table.put(InventoryTable.d_water
                ," TEXT");
                table.put(InventoryTable.d_hand_soap
                ," TEXT");
                table.put(InventoryTable.d_spirit
                ," TEXT");
                table.put(InventoryTable.d_waste_recycle
                ," TEXT");
                table.put(InventoryTable.d_waste_storage
                ," TEXT");
                table.put(InventoryTable.d_latex_gloves
                ," TEXT");
                table.put(InventoryTable.d_chlorine_sol
                ," TEXT");
                table.put(InventoryTable.d_detergent_water
                ," TEXT");
                table.put(InventoryTable.d_clean_water
                ," TEXT");
                table.put(InventoryTable.d_misoprostol
                ," TEXT");
                table.put(InventoryTable.d_oxytocin
                ," TEXT");
                table.put(InventoryTable.d_mang_sulfate
                ," TEXT");
                table.put(InventoryTable.d_chlorhexidine
                ," TEXT");
                table.put(InventoryTable.d_paediatric_drop
                ," TEXT");
                table.put(InventoryTable.d_gentamycin
                ," TEXT");
                table.put(InventoryTable.ch_wing_scale
                ," TEXT");
                table.put(InventoryTable.ch_infant_wing_scale
                ," TEXT");
                table.put(InventoryTable.ch_height_rod
                ," TEXT");
                table.put(InventoryTable.ch_measuring_tip
                ," TEXT");
                table.put(InventoryTable.ch_water
                ," TEXT");
                table.put(InventoryTable.ch_growth_monitor_boy
                ," TEXT");
                table.put(InventoryTable.ch_growth_monitor_girl
                ," TEXT");
                table.put(InventoryTable.ch_hand_soap
                ," TEXT");
                table.put(InventoryTable.ch_spirit
                ," TEXT");
                table.put(InventoryTable.ch_wastage_recycle
                ," TEXT");
                table.put(InventoryTable.ch_sharp_waste
                ," TEXT");
                table.put(InventoryTable.ch_latex_gloves
                ," TEXT");
                table.put(InventoryTable.ch_ors
                ," TEXT");
                table.put(InventoryTable.ch_paediatric_drop
                ," TEXT");
                table.put(InventoryTable.ch_cotrimoxazole
                ," TEXT");
                table.put(InventoryTable.ch_paracetamol
                ," TEXT");
                table.put(InventoryTable.ch_zinc
                ," TEXT");
                table.put(InventoryTable.ch_mebandazole
                ," TEXT");
                table.put(InventoryTable.ch_ceftriaxone
                ," TEXT");
                table.put(InventoryTable.ch_vitamin
                ," TEXT");
                table.put(InventoryTable.fp_soap
                ," TEXT");
                table.put(InventoryTable.fp_spirit
                ," TEXT");
                table.put(InventoryTable.fp_waste_recycle
                ," TEXT");
                table.put(InventoryTable.fp_sharp_waste
                ," TEXT");
                table.put(InventoryTable.fp_latex_gloves
                ," TEXT");
                table.put(InventoryTable.r_healthy_newborn
                ," TEXT");
                table.put(InventoryTable.r_newborn_death
                ," TEXT");
                table.put(InventoryTable.r_mother_rate
                ," TEXT");
                table.put(InventoryTable.r_elampsia
                ," TEXT");
                table.put(InventoryTable.r_mang_sulfate
                ," TEXT");
                table.put(InventoryTable.r_pneumonis
                ," TEXT");
                table.put(InventoryTable.r_paracetamol
                ," TEXT");
                table.put(InventoryTable.r_psbi
                ," TEXT");
                table.put(InventoryTable.r_psbi_care
                ," TEXT");
                table.put(InventoryTable.r_starving_child
                ," TEXT");
                table.put(InventoryTable.r_starving_protocol
                ," TEXT");
                table.put(InventoryTable.end_time
                ," TEXT");
                table.put(InventoryTable.village
                ," TEXT");
                table.put(InventoryTable.district
                ," TEXT");
                table.put(InventoryTable.union
                ," TEXT");
                table.put(InventoryTable.sub_district
                ," TEXT");

        table.put(DBRow.KEY_STATUS,"integer");

        table.put(KEY_USER_ID,"text");
        table.put(KEY_COMMENTS,"text");
        table.put(KEY_FIELDS,"text");
        table.put(KEY_META,"text");
        table.put(KEY_SUBMITTED_BY,"text");
        table.put(KEY_FORM_TYPE,"text");
        setNewTable(TABLE_NAME, table);




    }

    public long insert(InventoryItem item){
        ContentValues values = new ContentValues();
        values.put(KEY_ID,item.id);
        values.put(facility_id,Integer.toString(item.facility_id));
        values.put(client_name,item.client_name);
        values.put(start_time,item.start_time);
        values.put(instrument_sp_name,item.instrument_sp_name);
        values.put(instrument_sp_designation,item.instrument_sp_designation);
        values.put(i_electronic_autoclev,item.i_electronic_autoclev);
        values.put(i_non_electronic_autoclev,item.i_non_electronic_autoclev);
        values.put(i_electric_sterilizer,item.i_electric_sterilizer);
        values.put(i_electric_steamer,item.i_electric_steamer);
        values.put(i_non_electric_pot,item.i_non_electric_pot);
        values.put(i_stove,item.i_stove);
        values.put(i_waste_sp_name,item.i_waste_sp_name);
        values.put(i_waste_sp_designation,item.i_waste_sp_designation);
        values.put(w_waste_option,item.w_waste_option);
        values.put(w_waste_dispose_how,item.w_waste_dispose_how);
        values.put(w_pointy_waste,item.w_pointy_waste);
        values.put(w_liquid_waste,item.w_liquid_waste);
        values.put(w_liquid_waste_store,item.w_liquid_waste_store);
        values.put(w_plastic_waste,item.w_plastic_waste);
        values.put(w_waste_normal,item.w_waste_normal);
        values.put(w_incinerator_seen,item.w_incinerator_seen);
        values.put(w_dumping_pit_seen,item.w_dumping_pit_seen);
        values.put(equipment_sp_name,item.equipment_sp_name);
        values.put(equipment_sp_designation,item.equipment_sp_designation);
        values.put(w_incinerator,item.w_incinerator);
        values.put(w_dumping_pit,item.w_dumping_pit);
        values.put(n_adult_wing_scale,item.n_adult_wing_scale);
        values.put(n_height_rod,item.n_height_rod);
        values.put(n_pressure_mechine,item.n_pressure_mechine);
        values.put(n_stethoscope,item.n_stethoscope);
        values.put(n_filter_stethoscope,item.n_filter_stethoscope);
        values.put(n_water,item.n_water);
        values.put(n_hand_soap,item.n_hand_soap);
        values.put(n_spirit,item.n_spirit);
        values.put(n_waste,item.n_waste);
        values.put(n_sharp_waste,item.n_sharp_waste);
        values.put(n_gloves,item.n_gloves);
        values.put(n_iron_folate,item.n_iron_folate);
        values.put(n_urine_protien,item.n_urine_protien);
        values.put(n_urine_tester,item.n_urine_tester);
        values.put(n_urine_testtube,item.n_urine_testtube);
        values.put(n_test_tube_rack,item.n_test_tube_rack);
        values.put(n_dip_stick,item.n_dip_stick);
        values.put(n_hemoglobin,item.n_hemoglobin);
        values.put(n_telecoil_book,item.n_telecoil_book);
        values.put(n_telecoil_landset,item.n_telecoil_landset);
        values.put(n_kolori_meter,item.n_kolori_meter);
        values.put(n_litmus_paper,item.n_litmus_paper);
        values.put(delivery_sp_name,item.delivery_sp_name);
        values.put(delivery_sp_designation,item.delivery_sp_designation);
        values.put(d_delivery_service,item.d_delivery_service);
        values.put(d_delivery_table,item.d_delivery_table);
        values.put(d_pressure_mechine,item.d_pressure_mechine);
        values.put(d_stethoscope,item.d_stethoscope);
        values.put(d_filter_stethoscope,item.d_filter_stethoscope);
        values.put(d_newborn_recuscitation,item.d_newborn_recuscitation);
        values.put(d_recuscitation_mask_0,item.d_recuscitation_mask_0);
        values.put(d_recuscitation_mask_1,item.d_recuscitation_mask_1);
        values.put(d_peguin_sucker,item.d_peguin_sucker);
        values.put(d_cord_cutter,item.d_cord_cutter);
        values.put(d_cord_clamp,item.d_cord_clamp);
        values.put(d_partograf_paper,item.d_partograf_paper);
        values.put(d_water,item.d_water);
        values.put(d_hand_soap,item.d_hand_soap);
        values.put(d_spirit,item.d_spirit);
        values.put(d_waste_recycle,item.d_waste_recycle);
        values.put(d_waste_storage,item.d_waste_storage);
        values.put(d_latex_gloves,item.d_latex_gloves);
        values.put(d_chlorine_sol,item.d_chlorine_sol);
        values.put(d_detergent_water,item.d_detergent_water);
        values.put(d_clean_water,item.d_clean_water);
        values.put(d_misoprostol,item.d_misoprostol);
        values.put(d_oxytocin,item.d_oxytocin);
        values.put(d_mang_sulfate,item.d_mang_sulfate);
        values.put(d_chlorhexidine,item.d_chlorhexidine);
        values.put(d_paediatric_drop,item.d_paediatric_drop);
        values.put(d_gentamycin,item.d_gentamycin);
        values.put(ch_wing_scale,item.ch_wing_scale);
        values.put(ch_infant_wing_scale,item.ch_infant_wing_scale);
        values.put(ch_height_rod,item.ch_height_rod);
        values.put(ch_measuring_tip,item.ch_measuring_tip);
        values.put(ch_water,item.ch_water);
        values.put(ch_growth_monitor_boy,item.ch_growth_monitor_boy);
        values.put(ch_growth_monitor_girl,item.ch_growth_monitor_girl);
        values.put(ch_hand_soap,item.ch_hand_soap);
        values.put(ch_spirit,item.ch_spirit);
        values.put(ch_wastage_recycle,item.ch_wastage_recycle);
        values.put(ch_sharp_waste,item.ch_sharp_waste);
        values.put(ch_latex_gloves,item.ch_latex_gloves);
        values.put(ch_ors,item.ch_ors);
        values.put(ch_paediatric_drop,item.ch_paediatric_drop);
        values.put(ch_cotrimoxazole,item.ch_cotrimoxazole);
        values.put(ch_paracetamol,item.ch_paracetamol);
        values.put(ch_zinc,item.ch_zinc);
        values.put(ch_mebandazole,item.ch_mebandazole);
        values.put(ch_ceftriaxone,item.ch_ceftriaxone);
        values.put(ch_vitamin,item.ch_vitamin);
        values.put(fp_soap,item.fp_soap);
        values.put(fp_spirit,item.fp_spirit);
        values.put(fp_waste_recycle,item.fp_waste_recycle);
        values.put(fp_sharp_waste,item.fp_sharp_waste);
        values.put(fp_latex_gloves,item.fp_latex_gloves);
        values.put(r_healthy_newborn,item.r_healthy_newborn);
        values.put(r_newborn_death,item.r_newborn_death);
        values.put(r_mother_rate,item.r_mother_rate);
        values.put(r_elampsia,item.r_elampsia);
        values.put(r_mang_sulfate,item.r_mang_sulfate);
        values.put(r_pneumonis,item.r_pneumonis);
        values.put(r_paracetamol,item.r_paracetamol);
        values.put(r_psbi,item.r_psbi);
        values.put(r_psbi_care,item.r_psbi_care);
        values.put(r_starving_child,item.r_starving_child);
        values.put(r_starving_protocol,item.r_starving_protocol);
        values.put(end_time,item.end_time);

        values.put(DBRow.KEY_STATUS,item.status);
        values.put(KEY_USER_ID,item.user_id);
        values.put(KEY_COMMENTS,item.comments);
        values.put(KEY_FIELDS,item.fields);
        values.put(KEY_META,item.meta);
        values.put(KEY_SUBMITTED_BY,item.submittedBy);
        values.put(KEY_FORM_TYPE,item.form_type);

        SQLiteDatabase db = openDB();
        boolean hasItem = hasItem(item.id);
        if(hasItem){
            db.update(TABLE_NAME,values,KEY_ID + "=" + item.id,null);
        }
        else {
            long id = db.insert(TABLE_NAME, null, values);
            Log.e("inventory id:","" + id);
        }
        closeDB();
        return item.id;
    }

    public static List<DBRow> toDbrow(List<InventoryItem> list){
        List<DBRow> result = new ArrayList<>();
        for(InventoryItem item : list){
            result.add(item);
        }
        return result;
    }

    public InventoryItem get(long id) {

        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " where _id=" + id, null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                return cursorToSubCatList(cursor);
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return new InventoryItem();
    }

    public InventoryItem cursorToSubCatList(Cursor cursor){
        InventoryItem item = new InventoryItem();
        item.id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
        item.facility_id = cursor.getInt(cursor.getColumnIndex(facility_id));
        item.name = item.client_name = cursor.getString(cursor.getColumnIndex(client_name));
        item.start_time = cursor.getString(cursor.getColumnIndex(start_time));
        item.instrument_sp_name = cursor.getString(cursor.getColumnIndex(instrument_sp_name));
        item.instrument_sp_designation = cursor.getString(cursor.getColumnIndex(instrument_sp_designation));
        item.i_electronic_autoclev = cursor.getString(cursor.getColumnIndex(i_electronic_autoclev));
        item.i_non_electronic_autoclev = cursor.getString(cursor.getColumnIndex(i_non_electronic_autoclev));
        item.i_electric_sterilizer = cursor.getString(cursor.getColumnIndex(i_electric_sterilizer));
        item.i_electric_steamer = cursor.getString(cursor.getColumnIndex(i_electric_steamer));
        item.i_non_electric_pot = cursor.getString(cursor.getColumnIndex(i_non_electric_pot));
        item.i_stove = cursor.getString(cursor.getColumnIndex(i_stove));
        item.i_waste_sp_name = cursor.getString(cursor.getColumnIndex(i_waste_sp_name));
        item.i_waste_sp_designation = cursor.getString(cursor.getColumnIndex(i_waste_sp_designation));
        item.w_waste_option = cursor.getString(cursor.getColumnIndex(w_waste_option));
        item.w_waste_dispose_how = cursor.getString(cursor.getColumnIndex(w_waste_dispose_how));
        item.w_pointy_waste = cursor.getString(cursor.getColumnIndex(w_pointy_waste));
        item.w_liquid_waste = cursor.getString(cursor.getColumnIndex(w_liquid_waste));
        item.w_liquid_waste_store = cursor.getString(cursor.getColumnIndex(w_liquid_waste_store));
        item.w_plastic_waste = cursor.getString(cursor.getColumnIndex(w_plastic_waste));
        item.w_waste_normal = cursor.getString(cursor.getColumnIndex(w_waste_normal));
        item.w_incinerator_seen = cursor.getString(cursor.getColumnIndex(w_incinerator_seen));
        item.w_dumping_pit_seen = cursor.getString(cursor.getColumnIndex(w_dumping_pit_seen));
        item.equipment_sp_name = cursor.getString(cursor.getColumnIndex(equipment_sp_name));
        item.equipment_sp_designation = cursor.getString(cursor.getColumnIndex(equipment_sp_designation));
        item.w_incinerator = cursor.getString(cursor.getColumnIndex(w_incinerator));
        item.w_dumping_pit = cursor.getString(cursor.getColumnIndex(w_dumping_pit));
        item.n_adult_wing_scale = cursor.getString(cursor.getColumnIndex(n_adult_wing_scale));
        item.n_height_rod = cursor.getString(cursor.getColumnIndex(n_height_rod));
        item.n_pressure_mechine = cursor.getString(cursor.getColumnIndex(n_pressure_mechine));
        item.n_stethoscope = cursor.getString(cursor.getColumnIndex(n_stethoscope));
        item.n_filter_stethoscope = cursor.getString(cursor.getColumnIndex(n_filter_stethoscope));
        item.n_water = cursor.getString(cursor.getColumnIndex(n_water));
        item.n_hand_soap = cursor.getString(cursor.getColumnIndex(n_hand_soap));
        item.n_spirit = cursor.getString(cursor.getColumnIndex(n_spirit));
        item.n_waste = cursor.getString(cursor.getColumnIndex(n_waste));
        item.n_sharp_waste = cursor.getString(cursor.getColumnIndex(n_sharp_waste));
        item.n_gloves = cursor.getString(cursor.getColumnIndex(n_gloves));
        item.n_iron_folate = cursor.getString(cursor.getColumnIndex(n_iron_folate));
        item.n_urine_protien = cursor.getString(cursor.getColumnIndex(n_urine_protien));
        item.n_urine_tester = cursor.getString(cursor.getColumnIndex(n_urine_tester));
        item.n_urine_testtube = cursor.getString(cursor.getColumnIndex(n_urine_testtube));
        item.n_test_tube_rack = cursor.getString(cursor.getColumnIndex(n_test_tube_rack));
        item.n_dip_stick = cursor.getString(cursor.getColumnIndex(n_dip_stick));
        item.n_hemoglobin = cursor.getString(cursor.getColumnIndex(n_hemoglobin));
        item.n_telecoil_book = cursor.getString(cursor.getColumnIndex(n_telecoil_book));
        item.n_telecoil_landset = cursor.getString(cursor.getColumnIndex(n_telecoil_landset));
        item.n_kolori_meter = cursor.getString(cursor.getColumnIndex(n_kolori_meter));
        item.n_litmus_paper = cursor.getString(cursor.getColumnIndex(n_litmus_paper));
        item.delivery_sp_name = cursor.getString(cursor.getColumnIndex(delivery_sp_name));
        item.delivery_sp_designation = cursor.getString(cursor.getColumnIndex(delivery_sp_designation));
        item.d_delivery_service = cursor.getString(cursor.getColumnIndex(d_delivery_service));
        item.d_delivery_table = cursor.getString(cursor.getColumnIndex(d_delivery_table));
        item.d_pressure_mechine = cursor.getString(cursor.getColumnIndex(d_pressure_mechine));
        item.d_stethoscope = cursor.getString(cursor.getColumnIndex(d_stethoscope));
        item.d_filter_stethoscope = cursor.getString(cursor.getColumnIndex(d_filter_stethoscope));
        item.d_newborn_recuscitation = cursor.getString(cursor.getColumnIndex(d_newborn_recuscitation));
        item.d_recuscitation_mask_0 = cursor.getString(cursor.getColumnIndex(d_recuscitation_mask_0));
        item.d_recuscitation_mask_1 = cursor.getString(cursor.getColumnIndex(d_recuscitation_mask_1));
        item.d_peguin_sucker = cursor.getString(cursor.getColumnIndex(d_peguin_sucker));
        item.d_cord_cutter = cursor.getString(cursor.getColumnIndex(d_cord_cutter));
        item.d_cord_clamp = cursor.getString(cursor.getColumnIndex(d_cord_clamp));
        item.d_partograf_paper = cursor.getString(cursor.getColumnIndex(d_partograf_paper));
        item.d_water = cursor.getString(cursor.getColumnIndex(d_water));
        item.d_hand_soap = cursor.getString(cursor.getColumnIndex(d_hand_soap));
        item.d_spirit = cursor.getString(cursor.getColumnIndex(d_spirit));
        item.d_waste_recycle = cursor.getString(cursor.getColumnIndex(d_waste_recycle));
        item.d_waste_storage = cursor.getString(cursor.getColumnIndex(d_waste_storage));
        item.d_latex_gloves = cursor.getString(cursor.getColumnIndex(d_latex_gloves));
        item.d_chlorine_sol = cursor.getString(cursor.getColumnIndex(d_chlorine_sol));
        item.d_detergent_water = cursor.getString(cursor.getColumnIndex(d_detergent_water));
        item.d_clean_water = cursor.getString(cursor.getColumnIndex(d_clean_water));
        item.d_misoprostol = cursor.getString(cursor.getColumnIndex(d_misoprostol));
        item.d_oxytocin = cursor.getString(cursor.getColumnIndex(d_oxytocin));
        item.d_mang_sulfate = cursor.getString(cursor.getColumnIndex(d_mang_sulfate));
        item.d_chlorhexidine = cursor.getString(cursor.getColumnIndex(d_chlorhexidine));
        item.d_paediatric_drop = cursor.getString(cursor.getColumnIndex(d_paediatric_drop));
        item.d_gentamycin = cursor.getString(cursor.getColumnIndex(d_gentamycin));
        item.ch_wing_scale = cursor.getString(cursor.getColumnIndex(ch_wing_scale));
        item.ch_infant_wing_scale = cursor.getString(cursor.getColumnIndex(ch_infant_wing_scale));
        item.ch_height_rod = cursor.getString(cursor.getColumnIndex(ch_height_rod));
        item.ch_measuring_tip = cursor.getString(cursor.getColumnIndex(ch_measuring_tip));
        item.ch_water = cursor.getString(cursor.getColumnIndex(ch_water));
        item.ch_growth_monitor_boy = cursor.getString(cursor.getColumnIndex(ch_growth_monitor_boy));
        item.ch_growth_monitor_girl = cursor.getString(cursor.getColumnIndex(ch_growth_monitor_girl));
        item.ch_hand_soap = cursor.getString(cursor.getColumnIndex(ch_hand_soap));
        item.ch_spirit = cursor.getString(cursor.getColumnIndex(ch_spirit));
        item.ch_wastage_recycle = cursor.getString(cursor.getColumnIndex(ch_wastage_recycle));
        item.ch_sharp_waste = cursor.getString(cursor.getColumnIndex(ch_sharp_waste));
        item.ch_latex_gloves = cursor.getString(cursor.getColumnIndex(ch_latex_gloves));
        item.ch_ors = cursor.getString(cursor.getColumnIndex(ch_ors));
        item.ch_paediatric_drop = cursor.getString(cursor.getColumnIndex(ch_paediatric_drop));
        item.ch_cotrimoxazole = cursor.getString(cursor.getColumnIndex(ch_cotrimoxazole));
        item.ch_paracetamol = cursor.getString(cursor.getColumnIndex(ch_paracetamol));
        item.ch_zinc = cursor.getString(cursor.getColumnIndex(ch_zinc));
        item.ch_mebandazole = cursor.getString(cursor.getColumnIndex(ch_mebandazole));
        item.ch_ceftriaxone = cursor.getString(cursor.getColumnIndex(ch_ceftriaxone));
        item.ch_vitamin = cursor.getString(cursor.getColumnIndex(ch_vitamin));
        item.fp_soap = cursor.getString(cursor.getColumnIndex(fp_soap));
        item.fp_spirit = cursor.getString(cursor.getColumnIndex(fp_spirit));
        item.fp_waste_recycle = cursor.getString(cursor.getColumnIndex(fp_waste_recycle));
        item.fp_sharp_waste = cursor.getString(cursor.getColumnIndex(fp_sharp_waste));
        item.fp_latex_gloves = cursor.getString(cursor.getColumnIndex(fp_latex_gloves));
        item.r_healthy_newborn = cursor.getString(cursor.getColumnIndex(r_healthy_newborn));
        item.r_newborn_death = cursor.getString(cursor.getColumnIndex(r_newborn_death));
        item.r_mother_rate = cursor.getString(cursor.getColumnIndex(r_mother_rate));
        item.r_elampsia = cursor.getString(cursor.getColumnIndex(r_elampsia));
        item.r_mang_sulfate = cursor.getString(cursor.getColumnIndex(r_mang_sulfate));
        item.r_pneumonis = cursor.getString(cursor.getColumnIndex(r_pneumonis));
        item.r_paracetamol = cursor.getString(cursor.getColumnIndex(r_paracetamol));
        item.r_psbi = cursor.getString(cursor.getColumnIndex(r_psbi));
        item.r_psbi_care = cursor.getString(cursor.getColumnIndex(r_psbi_care));
        item.r_starving_child = cursor.getString(cursor.getColumnIndex(r_starving_child));
        item.r_starving_protocol = cursor.getString(cursor.getColumnIndex(r_starving_protocol));
        item.end_time = cursor.getString(cursor.getColumnIndex(end_time));

        item.status = cursor.getInt(cursor.getColumnIndex(DBRow.KEY_STATUS));
        item.comments = cursor.getString(cursor.getColumnIndex(KEY_COMMENTS));
        item.fields = cursor.getString(cursor.getColumnIndex(KEY_FIELDS));
        item.user_id = cursor.getString(cursor.getColumnIndex(KEY_USER_ID));
        item.meta = cursor.getString(cursor.getColumnIndex(KEY_META));
        item.submittedBy = cursor.getString(cursor.getColumnIndex(KEY_SUBMITTED_BY));
        item.form_type = cursor.getString(cursor.getColumnIndex(KEY_FORM_TYPE));
        return item;
    }

    public List<InventoryItem> getList(String cName, String facility) {
        ArrayList<InventoryItem> fpList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " where " + KEY_SUBMITTED_BY + "='" + cName + "'", null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                fpList.add(cursorToSubCatList(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return fpList;
    }
}
