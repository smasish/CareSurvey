package caresurvey.sci.com.caresurvey.model;

import org.json.JSONObject;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.InventoryTable;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by Shahin on 5/16/2016.
 */
public class InventoryItem extends DBRow{

    public InventoryItem(){
//        dat = AppUtils.getDate();
        start_time = AppUtils.getTime();
        end_time = AppUtils.getTime();
        status = 7;
    }
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getInstrument_sp_name() {
        return instrument_sp_name;
    }

    public void setInstrument_sp_name(String instrument_sp_name) {
        this.instrument_sp_name = instrument_sp_name;
    }

    public String getInstrument_sp_designation() {
        return instrument_sp_designation;
    }

    public void setInstrument_sp_designation(String instrument_sp_designation) {
        this.instrument_sp_designation = instrument_sp_designation;
    }

    public String getI_electronic_autoclev() {
        return i_electronic_autoclev;
    }

    public void setI_electronic_autoclev(String i_electronic_autoclev) {
        this.i_electronic_autoclev = i_electronic_autoclev;
    }

    public String getI_non_electronic_autoclev() {
        return i_non_electronic_autoclev;
    }

    public void setI_non_electronic_autoclev(String i_non_electronic_autoclev) {
        this.i_non_electronic_autoclev = i_non_electronic_autoclev;
    }

    public String getI_electric_sterilizer() {
        return i_electric_sterilizer;
    }

    public void setI_electric_sterilizer(String i_electric_sterilizer) {
        this.i_electric_sterilizer = i_electric_sterilizer;
    }

    public String getI_electric_steamer() {
        return i_electric_steamer;
    }

    public void setI_electric_steamer(String i_electric_steamer) {
        this.i_electric_steamer = i_electric_steamer;
    }

    public String getI_non_electric_pot() {
        return i_non_electric_pot;
    }

    public void setI_non_electric_pot(String i_non_electric_pot) {
        this.i_non_electric_pot = i_non_electric_pot;
    }

    public String getI_stove() {
        return i_stove;
    }

    public void setI_stove(String i_stove) {
        this.i_stove = i_stove;
    }

    public String getI_waste_sp_name() {
        return i_waste_sp_name;
    }

    public void setI_waste_sp_name(String i_waste_sp_name) {
        this.i_waste_sp_name = i_waste_sp_name;
    }

    public String getI_waste_sp_designation() {
        return i_waste_sp_designation;
    }

    public void setI_waste_sp_designation(String i_waste_sp_designation) {
        this.i_waste_sp_designation = i_waste_sp_designation;
    }

    public String getW_waste_option() {
        return w_waste_option;
    }

    public void setW_waste_option(String w_waste_option) {
        this.w_waste_option = w_waste_option;
    }

    public String getW_waste_dispose_how() {
        return w_waste_dispose_how;
    }

    public void setW_waste_dispose_how(String w_waste_dispose_how) {
        this.w_waste_dispose_how = w_waste_dispose_how;
    }

    public String getW_pointy_waste() {
        return w_pointy_waste;
    }

    public void setW_pointy_waste(String w_pointy_waste) {
        this.w_pointy_waste = w_pointy_waste;
    }

    public String getW_liquid_waste() {
        return w_liquid_waste;
    }

    public void setW_liquid_waste(String w_liquid_waste) {
        this.w_liquid_waste = w_liquid_waste;
    }

    public String getW_liquid_waste_store() {
        return w_liquid_waste_store;
    }

    public void setW_liquid_waste_store(String w_liquid_waste_store) {
        this.w_liquid_waste_store = w_liquid_waste_store;
    }

    public String getW_plastic_waste() {
        return w_plastic_waste;
    }

    public void setW_plastic_waste(String w_plastic_waste) {
        this.w_plastic_waste = w_plastic_waste;
    }

    public String getW_waste_normal() {
        return w_waste_normal;
    }

    public void setW_waste_normal(String w_waste_normal) {
        this.w_waste_normal = w_waste_normal;
    }

    public String getW_incinerator_seen() {
        return w_incinerator_seen;
    }

    public void setW_incinerator_seen(String w_incinerator_seen) {
        this.w_incinerator_seen = w_incinerator_seen;
    }

    public String getW_dumping_pit_seen() {
        return w_dumping_pit_seen;
    }

    public void setW_dumping_pit_seen(String w_dumping_pit_seen) {
        this.w_dumping_pit_seen = w_dumping_pit_seen;
    }

    public String getEquipment_sp_name() {
        return equipment_sp_name;
    }

    public void setEquipment_sp_name(String equipment_sp_name) {
        this.equipment_sp_name = equipment_sp_name;
    }

    public String getEquipment_sp_designation() {
        return equipment_sp_designation;
    }

    public void setEquipment_sp_designation(String equipment_sp_designation) {
        this.equipment_sp_designation = equipment_sp_designation;
    }

    public String getW_incinerator() {
        return w_incinerator;
    }

    public void setW_incinerator(String w_incinerator) {
        this.w_incinerator = w_incinerator;
    }

    public String getW_dumping_pit() {
        return w_dumping_pit;
    }

    public void setW_dumping_pit(String w_dumping_pit) {
        this.w_dumping_pit = w_dumping_pit;
    }

    public String getN_adult_wing_scale() {
        return n_adult_wing_scale;
    }

    public void setN_adult_wing_scale(String n_adult_wing_scale) {
        this.n_adult_wing_scale = n_adult_wing_scale;
    }

    public String getN_height_rod() {
        return n_height_rod;
    }

    public void setN_height_rod(String n_height_rod) {
        this.n_height_rod = n_height_rod;
    }

    public String getN_pressure_mechine() {
        return n_pressure_mechine;
    }

    public void setN_pressure_mechine(String n_pressure_mechine) {
        this.n_pressure_mechine = n_pressure_mechine;
    }

    public String getN_stethoscope() {
        return n_stethoscope;
    }

    public void setN_stethoscope(String n_stethoscope) {
        this.n_stethoscope = n_stethoscope;
    }

    public String getN_filter_stethoscope() {
        return n_filter_stethoscope;
    }

    public void setN_filter_stethoscope(String n_filter_stethoscope) {
        this.n_filter_stethoscope = n_filter_stethoscope;
    }

    public String getN_water() {
        return n_water;
    }

    public void setN_water(String n_water) {
        this.n_water = n_water;
    }

    public String getN_hand_soap() {
        return n_hand_soap;
    }

    public void setN_hand_soap(String n_hand_soap) {
        this.n_hand_soap = n_hand_soap;
    }

    public String getN_spirit() {
        return n_spirit;
    }

    public void setN_spirit(String n_spirit) {
        this.n_spirit = n_spirit;
    }

    public String getN_waste() {
        return n_waste;
    }

    public void setN_waste(String n_waste) {
        this.n_waste = n_waste;
    }

    public String getN_sharp_waste() {
        return n_sharp_waste;
    }

    public void setN_sharp_waste(String n_sharp_waste) {
        this.n_sharp_waste = n_sharp_waste;
    }

    public String getN_gloves() {
        return n_gloves;
    }

    public void setN_gloves(String n_gloves) {
        this.n_gloves = n_gloves;
    }

    public String getN_iron_folate() {
        return n_iron_folate;
    }

    public void setN_iron_folate(String n_iron_folate) {
        this.n_iron_folate = n_iron_folate;
    }

    public String getN_urine_protien() {
        return n_urine_protien;
    }

    public void setN_urine_protien(String n_urine_protien) {
        this.n_urine_protien = n_urine_protien;
    }

    public String getN_urine_tester() {
        return n_urine_tester;
    }

    public void setN_urine_tester(String n_urine_tester) {
        this.n_urine_tester = n_urine_tester;
    }

    public String getN_urine_testtube() {
        return n_urine_testtube;
    }

    public void setN_urine_testtube(String n_urine_testtube) {
        this.n_urine_testtube = n_urine_testtube;
    }

    public String getN_test_tube_rack() {
        return n_test_tube_rack;
    }

    public void setN_test_tube_rack(String n_test_tube_rack) {
        this.n_test_tube_rack = n_test_tube_rack;
    }

    public String getN_dip_stick() {
        return n_dip_stick;
    }

    public void setN_dip_stick(String n_dip_stick) {
        this.n_dip_stick = n_dip_stick;
    }

    public String getN_hemoglobin() {
        return n_hemoglobin;
    }

    public void setN_hemoglobin(String n_hemoglobin) {
        this.n_hemoglobin = n_hemoglobin;
    }

    public String getN_telecoil_book() {
        return n_telecoil_book;
    }

    public void setN_telecoil_book(String n_telecoil_book) {
        this.n_telecoil_book = n_telecoil_book;
    }

    public String getN_telecoil_landset() {
        return n_telecoil_landset;
    }

    public void setN_telecoil_landset(String n_telecoil_landset) {
        this.n_telecoil_landset = n_telecoil_landset;
    }

    public String getN_kolori_meter() {
        return n_kolori_meter;
    }

    public void setN_kolori_meter(String n_kolori_meter) {
        this.n_kolori_meter = n_kolori_meter;
    }

    public String getN_litmus_paper() {
        return n_litmus_paper;
    }

    public void setN_litmus_paper(String n_litmus_paper) {
        this.n_litmus_paper = n_litmus_paper;
    }

    public String getDelivery_sp_name() {
        return delivery_sp_name;
    }

    public void setDelivery_sp_name(String delivery_sp_name) {
        this.delivery_sp_name = delivery_sp_name;
    }

    public String getDelivery_sp_designation() {
        return delivery_sp_designation;
    }

    public void setDelivery_sp_designation(String delivery_sp_designation) {
        this.delivery_sp_designation = delivery_sp_designation;
    }

    public String getD_delivery_table() {
        return d_delivery_table;
    }

    public void setD_delivery_table(String d_delivery_table) {
        this.d_delivery_table = d_delivery_table;
    }

    public String getD_pressure_mechine() {
        return d_pressure_mechine;
    }

    public void setD_pressure_mechine(String d_pressure_mechine) {
        this.d_pressure_mechine = d_pressure_mechine;
    }

    public String getD_stethoscope() {
        return d_stethoscope;
    }

    public void setD_stethoscope(String d_stethoscope) {
        this.d_stethoscope = d_stethoscope;
    }

    public String getD_filter_stethoscope() {
        return d_filter_stethoscope;
    }

    public void setD_filter_stethoscope(String d_filter_stethoscope) {
        this.d_filter_stethoscope = d_filter_stethoscope;
    }

    public String getD_newborn_recuscitation() {
        return d_newborn_recuscitation;
    }

    public void setD_newborn_recuscitation(String d_newborn_recuscitation) {
        this.d_newborn_recuscitation = d_newborn_recuscitation;
    }

    public String getD_recuscitation_mask_0() {
        return d_recuscitation_mask_0;
    }

    public void setD_recuscitation_mask_0(String d_recuscitation_mask_0) {
        this.d_recuscitation_mask_0 = d_recuscitation_mask_0;
    }

    public String getD_recuscitation_mask_1() {
        return d_recuscitation_mask_1;
    }

    public void setD_recuscitation_mask_1(String d_recuscitation_mask_1) {
        this.d_recuscitation_mask_1 = d_recuscitation_mask_1;
    }

    public String getD_peguin_sucker() {
        return d_peguin_sucker;
    }

    public void setD_peguin_sucker(String d_peguin_sucker) {
        this.d_peguin_sucker = d_peguin_sucker;
    }

    public String getD_cord_cutter() {
        return d_cord_cutter;
    }

    public void setD_cord_cutter(String d_cord_cutter) {
        this.d_cord_cutter = d_cord_cutter;
    }

    public String getD_cord_clamp() {
        return d_cord_clamp;
    }

    public void setD_cord_clamp(String d_cord_clamp) {
        this.d_cord_clamp = d_cord_clamp;
    }

    public String getD_partograf_paper() {
        return d_partograf_paper;
    }

    public void setD_partograf_paper(String d_partograf_paper) {
        this.d_partograf_paper = d_partograf_paper;
    }

    public String getD_water() {
        return d_water;
    }

    public void setD_water(String d_water) {
        this.d_water = d_water;
    }

    public String getD_hand_soap() {
        return d_hand_soap;
    }

    public void setD_hand_soap(String d_hand_soap) {
        this.d_hand_soap = d_hand_soap;
    }

    public String getD_spirit() {
        return d_spirit;
    }

    public void setD_spirit(String d_spirit) {
        this.d_spirit = d_spirit;
    }

    public String getD_waste_recycle() {
        return d_waste_recycle;
    }

    public void setD_waste_recycle(String d_waste_recycle) {
        this.d_waste_recycle = d_waste_recycle;
    }

    public String getD_waste_storage() {
        return d_waste_storage;
    }

    public void setD_waste_storage(String d_waste_storage) {
        this.d_waste_storage = d_waste_storage;
    }

    public String getD_latex_gloves() {
        return d_latex_gloves;
    }

    public void setD_latex_gloves(String d_latex_gloves) {
        this.d_latex_gloves = d_latex_gloves;
    }

    public String getD_chlorine_sol() {
        return d_chlorine_sol;
    }

    public void setD_chlorine_sol(String d_chlorine_sol) {
        this.d_chlorine_sol = d_chlorine_sol;
    }

    public String getD_detergent_water() {
        return d_detergent_water;
    }

    public void setD_detergent_water(String d_detergent_water) {
        this.d_detergent_water = d_detergent_water;
    }

    public String getD_clean_water() {
        return d_clean_water;
    }

    public void setD_clean_water(String d_clean_water) {
        this.d_clean_water = d_clean_water;
    }

    public String getD_misoprostol() {
        return d_misoprostol;
    }

    public void setD_misoprostol(String d_misoprostol) {
        this.d_misoprostol = d_misoprostol;
    }

    public String getD_oxytocin() {
        return d_oxytocin;
    }

    public void setD_oxytocin(String d_oxytocin) {
        this.d_oxytocin = d_oxytocin;
    }

    public String getD_mang_sulfate() {
        return d_mang_sulfate;
    }

    public void setD_mang_sulfate(String d_mang_sulfate) {
        this.d_mang_sulfate = d_mang_sulfate;
    }

    public String getD_chlorhexidine() {
        return d_chlorhexidine;
    }

    public void setD_chlorhexidine(String d_chlorhexidine) {
        this.d_chlorhexidine = d_chlorhexidine;
    }

    public String getD_paediatric_drop() {
        return d_paediatric_drop;
    }

    public void setD_paediatric_drop(String d_paediatric_drop) {
        this.d_paediatric_drop = d_paediatric_drop;
    }

    public String getD_gentamycin() {
        return d_gentamycin;
    }

    public void setD_gentamycin(String d_gentamycin) {
        this.d_gentamycin = d_gentamycin;
    }

    public String getCh_wing_scale() {
        return ch_wing_scale;
    }

    public void setCh_wing_scale(String ch_wing_scale) {
        this.ch_wing_scale = ch_wing_scale;
    }

    public String getCh_infant_wing_scale() {
        return ch_infant_wing_scale;
    }

    public void setCh_infant_wing_scale(String ch_infant_wing_scale) {
        this.ch_infant_wing_scale = ch_infant_wing_scale;
    }

    public String getCh_height_rod() {
        return ch_height_rod;
    }

    public void setCh_height_rod(String ch_height_rod) {
        this.ch_height_rod = ch_height_rod;
    }

    public String getCh_measuring_tip() {
        return ch_measuring_tip;
    }

    public void setCh_measuring_tip(String ch_measuring_tip) {
        this.ch_measuring_tip = ch_measuring_tip;
    }

    public String getCh_water() {
        return ch_water;
    }

    public void setCh_water(String ch_water) {
        this.ch_water = ch_water;
    }

    public String getCh_growth_monitor_boy() {
        return ch_growth_monitor_boy;
    }

    public void setCh_growth_monitor_boy(String ch_growth_monitor_boy) {
        this.ch_growth_monitor_boy = ch_growth_monitor_boy;
    }

    public String getCh_growth_monitor_girl() {
        return ch_growth_monitor_girl;
    }

    public void setCh_growth_monitor_girl(String ch_growth_monitor_girl) {
        this.ch_growth_monitor_girl = ch_growth_monitor_girl;
    }

    public String getCh_hand_soap() {
        return ch_hand_soap;
    }

    public void setCh_hand_soap(String ch_hand_soap) {
        this.ch_hand_soap = ch_hand_soap;
    }

    public String getCh_spirit() {
        return ch_spirit;
    }

    public void setCh_spirit(String ch_spirit) {
        this.ch_spirit = ch_spirit;
    }

    public String getCh_wastage_recycle() {
        return ch_wastage_recycle;
    }

    public void setCh_wastage_recycle(String ch_wastage_recycle) {
        this.ch_wastage_recycle = ch_wastage_recycle;
    }

    public String getCh_sharp_waste() {
        return ch_sharp_waste;
    }

    public void setCh_sharp_waste(String ch_sharp_waste) {
        this.ch_sharp_waste = ch_sharp_waste;
    }

    public String getCh_latex_gloves() {
        return ch_latex_gloves;
    }

    public void setCh_latex_gloves(String ch_latex_gloves) {
        this.ch_latex_gloves = ch_latex_gloves;
    }

    public String getCh_ors() {
        return ch_ors;
    }

    public void setCh_ors(String ch_ors) {
        this.ch_ors = ch_ors;
    }

    public String getCh_paediatric_drop() {
        return ch_paediatric_drop;
    }

    public void setCh_paediatric_drop(String ch_paediatric_drop) {
        this.ch_paediatric_drop = ch_paediatric_drop;
    }

    public String getCh_cotrimoxazole() {
        return ch_cotrimoxazole;
    }

    public void setCh_cotrimoxazole(String ch_cotrimoxazole) {
        this.ch_cotrimoxazole = ch_cotrimoxazole;
    }

    public String getCh_paracetamol() {
        return ch_paracetamol;
    }

    public void setCh_paracetamol(String ch_paracetamol) {
        this.ch_paracetamol = ch_paracetamol;
    }

    public String getCh_zinc() {
        return ch_zinc;
    }

    public void setCh_zinc(String ch_zinc) {
        this.ch_zinc = ch_zinc;
    }

    public String getCh_mebandazole() {
        return ch_mebandazole;
    }

    public void setCh_mebandazole(String ch_mebandazole) {
        this.ch_mebandazole = ch_mebandazole;
    }

    public String getCh_ceftriaxone() {
        return ch_ceftriaxone;
    }

    public void setCh_ceftriaxone(String ch_ceftriaxone) {
        this.ch_ceftriaxone = ch_ceftriaxone;
    }

    public String getCh_vitamin() {
        return ch_vitamin;
    }

    public void setCh_vitamin(String ch_vitamin) {
        this.ch_vitamin = ch_vitamin;
    }

    public String getFp_soap() {
        return fp_soap;
    }

    public void setFp_soap(String fp_soap) {
        this.fp_soap = fp_soap;
    }

    public String getFp_spirit() {
        return fp_spirit;
    }

    public void setFp_spirit(String fp_spirit) {
        this.fp_spirit = fp_spirit;
    }

    public String getFp_waste_recycle() {
        return fp_waste_recycle;
    }

    public void setFp_waste_recycle(String fp_waste_recycle) {
        this.fp_waste_recycle = fp_waste_recycle;
    }

    public String getFp_sharp_waste() {
        return fp_sharp_waste;
    }

    public void setFp_sharp_waste(String fp_sharp_waste) {
        this.fp_sharp_waste = fp_sharp_waste;
    }

    public String getFp_latex_gloves() {
        return fp_latex_gloves;
    }

    public void setFp_latex_gloves(String fp_latex_gloves) {
        this.fp_latex_gloves = fp_latex_gloves;
    }

    public String getR_healthy_newborn() {
        return r_healthy_newborn;
    }

    public void setR_healthy_newborn(String r_healthy_newborn) {
        this.r_healthy_newborn = r_healthy_newborn;
    }

    public String getR_newborn_death() {
        return r_newborn_death;
    }

    public void setR_newborn_death(String r_newborn_death) {
        this.r_newborn_death = r_newborn_death;
    }

    public String getR_mother_rate() {
        return r_mother_rate;
    }

    public void setR_mother_rate(String r_mother_rate) {
        this.r_mother_rate = r_mother_rate;
    }

    public String getR_elampsia() {
        return r_elampsia;
    }

    public void setR_elampsia(String r_elampsia) {
        this.r_elampsia = r_elampsia;
    }

    public String getR_mang_sulfate() {
        return r_mang_sulfate;
    }

    public void setR_mang_sulfate(String r_mang_sulfate) {
        this.r_mang_sulfate = r_mang_sulfate;
    }

    public String getR_pneumonis() {
        return r_pneumonis;
    }

    public void setR_pneumonis(String r_pneumonis) {
        this.r_pneumonis = r_pneumonis;
    }

    public String getR_paracetamol() {
        return r_paracetamol;
    }

    public void setR_paracetamol(String r_paracetamol) {
        this.r_paracetamol = r_paracetamol;
    }

    public String getR_psbi() {
        return r_psbi;
    }

    public void setR_psbi(String r_psbi) {
        this.r_psbi = r_psbi;
    }

    public String getR_psbi_care() {
        return r_psbi_care;
    }

    public void setR_psbi_care(String r_psbi_care) {
        this.r_psbi_care = r_psbi_care;
    }

    public String getR_starving_child() {
        return r_starving_child;
    }

    public void setR_starving_child(String r_starving_child) {
        this.r_starving_child = r_starving_child;
    }

    public String getR_starving_protocol() {
        return r_starving_protocol;
    }

    public void setR_starving_protocol(String r_starving_protocol) {
        this.r_starving_protocol = r_starving_protocol;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUnion() {
        return union;
    }

    public void setUnion(String union) {
        this.union = union;
    }

    public String getSub_district() {
        return subdistrict;
    }

    public void setSub_district(String sub_district) {
        this.subdistrict = sub_district;
    }

    public int facility_id;
    public String client_name;
    public String start_time;
    public String instrument_sp_name;
    public String instrument_sp_designation;
    public String i_electronic_autoclev;
    public String i_non_electronic_autoclev;
    public String i_electric_sterilizer;
    public String i_electric_steamer;
    public String i_non_electric_pot;
    public String i_stove;
    public String i_waste_sp_name;
    public String i_waste_sp_designation;
    public String w_waste_option;
    public String w_waste_dispose_how;
    public String w_pointy_waste;
    public String w_liquid_waste;
    public String w_liquid_waste_store;
    public String w_plastic_waste;
    public String w_waste_normal;
    public String w_incinerator_seen;
    public String w_dumping_pit_seen;
    public String equipment_sp_name;
    public String equipment_sp_designation;
    public String w_incinerator;
    public String w_dumping_pit;
    public String n_adult_wing_scale;
    public String n_height_rod;
    public String n_pressure_mechine;
    public String n_stethoscope;
    public String n_filter_stethoscope;
    public String n_water;
    public String n_hand_soap;
    public String n_spirit;
    public String n_waste;
    public String n_sharp_waste;
    public String n_gloves;
    public String n_iron_folate;
    public String n_urine_protien;
    public String n_urine_tester;
    public String n_urine_testtube;
    public String n_test_tube_rack;
    public String n_dip_stick;
    public String n_hemoglobin;
    public String n_telecoil_book;
    public String n_telecoil_landset;
    public String n_kolori_meter;
    public String n_litmus_paper;
    public String delivery_sp_name;
    public String delivery_sp_designation;
    public String d_delivery_service;
    public String d_delivery_table;
    public String d_pressure_mechine;
    public String d_stethoscope;
    public String d_filter_stethoscope;
    public String d_newborn_recuscitation;
    public String d_recuscitation_mask_0;
    public String d_recuscitation_mask_1;
    public String d_peguin_sucker;
    public String d_cord_cutter;
    public String d_cord_clamp;
    public String d_partograf_paper;
    public String d_water;
    public String d_hand_soap;
    public String d_spirit;
    public String d_waste_recycle;
    public String d_waste_storage;
    public String d_latex_gloves;
    public String d_chlorine_sol;
    public String d_detergent_water;
    public String d_clean_water;
    public String d_misoprostol;
    public String d_oxytocin;
    public String d_mang_sulfate;
    public String d_chlorhexidine;
    public String d_paediatric_drop;
    public String d_gentamycin;
    public String ch_wing_scale;
    public String ch_infant_wing_scale;
    public String ch_height_rod;
    public String ch_measuring_tip;
    public String ch_water;
    public String ch_growth_monitor_boy;
    public String ch_growth_monitor_girl;
    public String ch_hand_soap;
    public String ch_spirit;
    public String ch_wastage_recycle;
    public String ch_sharp_waste;
    public String ch_latex_gloves;
    public String ch_ors;
    public String ch_paediatric_drop;
    public String ch_cotrimoxazole;
    public String ch_paracetamol;
    public String ch_zinc;
    public String ch_mebandazole;
    public String ch_ceftriaxone;
    public String ch_vitamin;
    public String fp_soap;
    public String fp_spirit;
    public String fp_waste_recycle;
    public String fp_sharp_waste;
    public String fp_latex_gloves;
    public String r_healthy_newborn;
    public String r_newborn_death;
    public String r_mother_rate;
    public String r_elampsia;
    public String r_mang_sulfate;
    public String r_pneumonis;
    public String r_paracetamol;
    public String r_psbi;
    public String r_psbi_care;
    public String r_starving_child;
    public String r_starving_protocol;
    public String end_time;

    public static InventoryItem getObject(String json){
        InventoryItem item = new InventoryItem();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject data = object.getJSONObject("data");

            item.id = object.getInt("form_id");
            item.status = object.getInt("status");
            item.user_id = Integer.toString(object.getInt("user_id"));
            if (object.has("meta")) {
                try {
                    boolean b = object.getBoolean("meta");
                    if (b) {
                        item.meta = "true";
                    } else {
                        item.meta = "false";
                    }
                } catch (Exception e) {
                    JSONObject meta = null;
                    try {
                        meta = object.getJSONObject("meta");
                    }catch(Exception ex){

                    }
                    item.fields = AppUtils.getString(meta,"fields");
                    item.comments = AppUtils.getString(meta,"comments");
                }
            }
            item.submittedBy = object.getString("submitted_by");
            item.form_type = object.getString("form_type");

            item.facility_id = AppUtils.getInt(data,InventoryTable.facility_id);
            item.client_name = AppUtils.getString(data,InventoryTable.client_name);
            item.start_time = AppUtils.getString(data,InventoryTable.start_time);
            item.instrument_sp_name = AppUtils.getString(data, InventoryTable.instrument_sp_name);
            item.instrument_sp_designation = AppUtils.getString(data, InventoryTable.instrument_sp_designation);
            item.i_electronic_autoclev = AppUtils.getArray(data,InventoryTable.i_electronic_autoclev);
            item.i_non_electronic_autoclev = AppUtils.getArray(data,InventoryTable.i_non_electronic_autoclev);
            item.i_electric_sterilizer = AppUtils.getArray(data,InventoryTable.i_electric_sterilizer);
            item.i_electric_steamer = AppUtils.getArray(data,InventoryTable.i_electric_steamer);
            item.i_non_electric_pot = AppUtils.getArray(data,InventoryTable.i_non_electric_pot);
            item.i_stove = AppUtils.getArray(data,InventoryTable.i_stove);

            item.i_waste_sp_name = AppUtils.getString(data,InventoryTable.i_waste_sp_name);
            item.i_waste_sp_designation = AppUtils.getString(data,InventoryTable.i_waste_sp_designation);
            item.w_waste_option = AppUtils.getArray(data,InventoryTable.w_waste_option);
            item.w_waste_dispose_how = AppUtils.getArray(data,InventoryTable.w_waste_dispose_how);
            item.w_pointy_waste = AppUtils.getArray(data,InventoryTable.w_pointy_waste);
            item.w_liquid_waste = AppUtils.getArray(data,InventoryTable.w_liquid_waste);
            item.w_liquid_waste_store = AppUtils.getArray(data,InventoryTable.w_liquid_waste_store);
            item.w_plastic_waste = AppUtils.getArray(data,InventoryTable.w_plastic_waste);
            item.w_waste_normal = AppUtils.getArray(data,InventoryTable.w_waste_normal);
            item.w_incinerator_seen = AppUtils.getArray(data,InventoryTable.w_incinerator_seen);
            item.w_dumping_pit_seen = AppUtils.getArray(data,InventoryTable.w_dumping_pit_seen);

            item.equipment_sp_name = AppUtils.getString(data,InventoryTable.equipment_sp_name);
            item.equipment_sp_designation = AppUtils.getString(data,InventoryTable.equipment_sp_designation);
            item.n_adult_wing_scale = AppUtils.getArray(data,InventoryTable.n_adult_wing_scale);
            item.n_height_rod = AppUtils.getArray(data,InventoryTable.n_height_rod);
            item.n_pressure_mechine = AppUtils.getArray(data,InventoryTable.n_pressure_mechine);
            item.n_stethoscope = AppUtils.getArray(data,InventoryTable.n_stethoscope);
            item.n_filter_stethoscope = AppUtils.getArray(data,InventoryTable.n_filter_stethoscope);
            item.n_water = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_water));
            item.n_hand_soap = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_hand_soap));
            item.n_spirit = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_spirit));
            item.n_waste = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_waste));
            item.n_sharp_waste = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_sharp_waste));
            item.n_gloves = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_gloves));
            item.n_iron_folate = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_iron_folate));
            item.n_urine_protien = AppUtils.getString(data,InventoryTable.n_urine_protien);
            item.n_urine_tester = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_urine_tester));
            item.n_urine_testtube = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_urine_testtube));
            item.n_test_tube_rack = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_test_tube_rack));
            item.n_dip_stick = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_dip_stick));
            item.n_hemoglobin = AppUtils.getArray(data,InventoryTable.n_hemoglobin);
            item.n_telecoil_book = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_telecoil_book));
            item.n_telecoil_landset = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_telecoil_landset));
            item.n_kolori_meter = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_kolori_meter));
            item.n_litmus_paper = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_litmus_paper));

            item.delivery_sp_name = AppUtils.getString(data,InventoryTable.delivery_sp_name);
            item.delivery_sp_designation = AppUtils.getString(data,InventoryTable.delivery_sp_designation);
            item.d_delivery_service = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_delivery_service));
            item.d_delivery_table = AppUtils.getArray(data,InventoryTable.d_delivery_table);
            item.d_pressure_mechine = AppUtils.getArray(data,InventoryTable.d_pressure_mechine);
            item.d_stethoscope = AppUtils.getArray(data,InventoryTable.d_stethoscope);
            item.d_filter_stethoscope = AppUtils.getArray(data,InventoryTable.d_filter_stethoscope);
            item.d_newborn_recuscitation = AppUtils.getArray(data,InventoryTable.d_newborn_recuscitation);
            item.d_recuscitation_mask_0 = AppUtils.getArray(data,InventoryTable.d_recuscitation_mask_0);
            item.d_recuscitation_mask_1 = AppUtils.getArray(data,InventoryTable.d_recuscitation_mask_1);
            item.d_peguin_sucker = AppUtils.getArray(data,InventoryTable.d_peguin_sucker);
            item.d_cord_cutter = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_cord_cutter));
            item.d_cord_clamp = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_cord_clamp));
            item.d_partograf_paper = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_partograf_paper));
            item.d_water = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_water));
            item.d_hand_soap = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_hand_soap));
            item.d_spirit = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_spirit));
            item.d_waste_recycle = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_waste_recycle));
            item.d_waste_storage = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_waste_storage));
            item.d_latex_gloves = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_latex_gloves));
            item.d_chlorine_sol = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_chlorine_sol));
            item.d_detergent_water = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_detergent_water));
            item.d_clean_water = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_clean_water));
            item.d_misoprostol = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_misoprostol));
            item.d_oxytocin = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_oxytocin));
            item.d_mang_sulfate = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_mang_sulfate));
            item.d_chlorhexidine = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_chlorhexidine));
            item.d_paediatric_drop = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_paediatric_drop));
            item.d_gentamycin = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_gentamycin));

            item.ch_wing_scale = AppUtils.getArray(data,InventoryTable.ch_wing_scale);
            item.ch_infant_wing_scale = AppUtils.getArray(data,InventoryTable.ch_infant_wing_scale);
            item.ch_height_rod = AppUtils.getArray(data,InventoryTable.ch_height_rod);
            item.ch_measuring_tip = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_measuring_tip));
            item.ch_water = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_water));
            item.ch_growth_monitor_boy = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_growth_monitor_boy));
            item.ch_growth_monitor_girl = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_growth_monitor_girl));
            item.ch_hand_soap = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_hand_soap));
            item.ch_spirit = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_spirit));
            item.ch_wastage_recycle = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_wastage_recycle));
            item.ch_sharp_waste = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_sharp_waste));
            item.ch_latex_gloves = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_latex_gloves));
            item.ch_ors = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_ors));
            item.ch_paediatric_drop = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_paediatric_drop));
            item.ch_cotrimoxazole = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_cotrimoxazole));
            item.ch_paracetamol = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_paracetamol));
            item.ch_zinc = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_zinc));
            item.ch_mebandazole = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_mebandazole));
            item.ch_ceftriaxone = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_ceftriaxone));
            item.ch_vitamin = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_vitamin));
            item.fp_soap = AppUtils.itos(AppUtils.getInt(data,InventoryTable.fp_soap));
            item.fp_spirit = AppUtils.itos(AppUtils.getInt(data,InventoryTable.fp_spirit));
            item.fp_waste_recycle = AppUtils.itos(AppUtils.getInt(data,InventoryTable.fp_waste_recycle));
            item.fp_sharp_waste = AppUtils.itos(AppUtils.getInt(data,InventoryTable.fp_sharp_waste));
            item.fp_latex_gloves = AppUtils.itos(AppUtils.getInt(data,InventoryTable.fp_latex_gloves));

            item.r_healthy_newborn = AppUtils.getArray(data,InventoryTable.r_healthy_newborn);
            item.r_newborn_death = AppUtils.getArray(data,InventoryTable.r_newborn_death);
            item.r_mother_rate = AppUtils.getArray(data,InventoryTable.r_mother_rate);
            item.r_elampsia = AppUtils.getArray(data,InventoryTable.r_elampsia);
            item.r_mang_sulfate = AppUtils.getArray(data,InventoryTable.r_mang_sulfate);
            item.r_pneumonis = AppUtils.getArray(data,InventoryTable.r_pneumonis);
            item.r_paracetamol = AppUtils.getArray(data,InventoryTable.r_paracetamol);
            item.r_psbi = AppUtils.getArray(data,InventoryTable.r_psbi);
            item.r_psbi_care = AppUtils.getArray(data,InventoryTable.r_psbi_care);
            item.r_starving_child = AppUtils.getArray(data,InventoryTable.r_starving_child);
            item.r_starving_protocol = AppUtils.getArray(data,InventoryTable.r_starving_protocol);
            item.end_time = AppUtils.getString(data,InventoryTable.end_time);
            item.facility = AppUtils.getString(data,"facility");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  item;
    }

    public static InventoryItem getUserObject(String json){
        InventoryItem item = new InventoryItem();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject data = object.getJSONObject("data");

            item.id = object.getInt("form_id");
            item.status = object.getInt("status");
            item.facility_id = AppUtils.getInt(data,InventoryTable.facility_id);
            item.client_name = AppUtils.getString(data,InventoryTable.client_name);
            item.start_time = AppUtils.getString(data,InventoryTable.start_time);
            item.instrument_sp_name = AppUtils.getString(data, InventoryTable.instrument_sp_name);
            item.instrument_sp_designation = AppUtils.getString(data, InventoryTable.instrument_sp_designation);
            item.i_electronic_autoclev = AppUtils.getArray(data,InventoryTable.i_electronic_autoclev);
            item.i_non_electronic_autoclev = AppUtils.getArray(data,InventoryTable.i_non_electronic_autoclev);
            item.i_electric_sterilizer = AppUtils.getArray(data,InventoryTable.i_electric_sterilizer);
            item.i_electric_steamer = AppUtils.getArray(data,InventoryTable.i_electric_steamer);
            item.i_non_electric_pot = AppUtils.getArray(data,InventoryTable.i_non_electric_pot);
            item.i_stove = AppUtils.getArray(data,InventoryTable.i_stove);

            item.i_waste_sp_name = AppUtils.getString(data,InventoryTable.i_waste_sp_name);
            item.i_waste_sp_designation = AppUtils.getString(data,InventoryTable.i_waste_sp_designation);
            item.w_waste_option = AppUtils.getArray(data,InventoryTable.w_waste_option);
            item.w_waste_dispose_how = AppUtils.getArray(data,InventoryTable.w_waste_dispose_how);
            item.w_pointy_waste = AppUtils.getArray(data,InventoryTable.w_pointy_waste);
            item.w_liquid_waste = AppUtils.getArray(data,InventoryTable.w_liquid_waste);
            item.w_liquid_waste_store = AppUtils.getArray(data,InventoryTable.w_liquid_waste_store);
            item.w_plastic_waste = AppUtils.getArray(data,InventoryTable.w_plastic_waste);
            item.w_waste_normal = AppUtils.getArray(data,InventoryTable.w_waste_normal);
            item.w_incinerator_seen = AppUtils.getArray(data,InventoryTable.w_incinerator_seen);
            item.w_dumping_pit_seen = AppUtils.getArray(data,InventoryTable.w_dumping_pit_seen);

            item.equipment_sp_name = AppUtils.getString(data,InventoryTable.equipment_sp_name);
            item.equipment_sp_designation = AppUtils.getString(data,InventoryTable.equipment_sp_designation);
            item.n_adult_wing_scale = AppUtils.getArray(data,InventoryTable.n_adult_wing_scale);
            item.n_height_rod = AppUtils.getArray(data,InventoryTable.n_height_rod);
            item.n_pressure_mechine = AppUtils.getArray(data,InventoryTable.n_pressure_mechine);
            item.n_stethoscope = AppUtils.getArray(data,InventoryTable.n_stethoscope);
            item.n_filter_stethoscope = AppUtils.getArray(data,InventoryTable.n_filter_stethoscope);
            item.n_water = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_water));
            item.n_hand_soap = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_hand_soap));
            item.n_spirit = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_spirit));
            item.n_waste = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_waste));
            item.n_sharp_waste = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_sharp_waste));
            item.n_gloves = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_gloves));
            item.n_iron_folate = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_iron_folate));
            item.n_urine_protien = AppUtils.getString(data,InventoryTable.n_urine_protien);
            item.n_urine_tester = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_urine_tester));
            item.n_urine_testtube = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_urine_testtube));
            item.n_test_tube_rack = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_test_tube_rack));
            item.n_dip_stick = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_dip_stick));
            item.n_hemoglobin = AppUtils.getArray(data,InventoryTable.n_hemoglobin);
            item.n_telecoil_book = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_telecoil_book));
            item.n_telecoil_landset = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_telecoil_landset));
            item.n_kolori_meter = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_kolori_meter));
            item.n_litmus_paper = AppUtils.itos(AppUtils.getInt(data,InventoryTable.n_litmus_paper));

            item.delivery_sp_name = AppUtils.getString(data,InventoryTable.delivery_sp_name);
            item.delivery_sp_designation = AppUtils.getString(data,InventoryTable.delivery_sp_designation);
            item.d_delivery_service = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_delivery_service));
            item.d_delivery_table = AppUtils.getArray(data,InventoryTable.d_delivery_table);
            item.d_pressure_mechine = AppUtils.getArray(data,InventoryTable.d_pressure_mechine);
            item.d_stethoscope = AppUtils.getArray(data,InventoryTable.d_stethoscope);
            item.d_filter_stethoscope = AppUtils.getArray(data,InventoryTable.d_filter_stethoscope);
            item.d_newborn_recuscitation = AppUtils.getArray(data,InventoryTable.d_newborn_recuscitation);
            item.d_recuscitation_mask_0 = AppUtils.getArray(data,InventoryTable.d_recuscitation_mask_0);
            item.d_recuscitation_mask_1 = AppUtils.getArray(data,InventoryTable.d_recuscitation_mask_1);
            item.d_peguin_sucker = AppUtils.getArray(data,InventoryTable.d_peguin_sucker);
            item.d_cord_cutter = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_cord_cutter));
            item.d_cord_clamp = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_cord_clamp));
            item.d_partograf_paper = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_partograf_paper));
            item.d_water = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_water));
            item.d_hand_soap = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_hand_soap));
            item.d_spirit = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_spirit));
            item.d_waste_recycle = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_waste_recycle));
            item.d_waste_storage = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_waste_storage));
            item.d_latex_gloves = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_latex_gloves));
            item.d_chlorine_sol = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_chlorine_sol));
            item.d_detergent_water = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_detergent_water));
            item.d_clean_water = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_clean_water));
            item.d_misoprostol = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_misoprostol));
            item.d_oxytocin = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_oxytocin));
            item.d_mang_sulfate = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_mang_sulfate));
            item.d_chlorhexidine = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_chlorhexidine));
            item.d_paediatric_drop = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_paediatric_drop));
            item.d_gentamycin = AppUtils.itos(AppUtils.getInt(data,InventoryTable.d_gentamycin));

            item.ch_wing_scale = AppUtils.getArray(data,InventoryTable.ch_wing_scale);
            item.ch_infant_wing_scale = AppUtils.getArray(data,InventoryTable.ch_infant_wing_scale);
            item.ch_height_rod = AppUtils.getArray(data,InventoryTable.ch_height_rod);
            item.ch_measuring_tip = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_measuring_tip));
            item.ch_water = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_water));
            item.ch_growth_monitor_boy = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_growth_monitor_boy));
            item.ch_growth_monitor_girl = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_growth_monitor_girl));
            item.ch_hand_soap = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_hand_soap));
            item.ch_spirit = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_spirit));
            item.ch_wastage_recycle = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_wastage_recycle));
            item.ch_sharp_waste = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_sharp_waste));
            item.ch_latex_gloves = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_latex_gloves));
            item.ch_ors = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_ors));
            item.ch_paediatric_drop = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_paediatric_drop));
            item.ch_cotrimoxazole = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_cotrimoxazole));
            item.ch_paracetamol = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_paracetamol));
            item.ch_zinc = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_zinc));
            item.ch_mebandazole = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_mebandazole));
            item.ch_ceftriaxone = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_ceftriaxone));
            item.ch_vitamin = AppUtils.itos(AppUtils.getInt(data,InventoryTable.ch_vitamin));
            item.fp_soap = AppUtils.itos(AppUtils.getInt(data,InventoryTable.fp_soap));
            item.fp_spirit = AppUtils.itos(AppUtils.getInt(data,InventoryTable.fp_spirit));
            item.fp_waste_recycle = AppUtils.itos(AppUtils.getInt(data,InventoryTable.fp_waste_recycle));
            item.fp_sharp_waste = AppUtils.itos(AppUtils.getInt(data,InventoryTable.fp_sharp_waste));
            item.fp_latex_gloves = AppUtils.itos(AppUtils.getInt(data,InventoryTable.fp_latex_gloves));

            item.r_healthy_newborn = AppUtils.getArray(data,InventoryTable.r_healthy_newborn);
            item.r_newborn_death = AppUtils.getArray(data,InventoryTable.r_newborn_death);
            item.r_mother_rate = AppUtils.getArray(data,InventoryTable.r_mother_rate);
            item.r_elampsia = AppUtils.getArray(data,InventoryTable.r_elampsia);
            item.r_mang_sulfate = AppUtils.getArray(data,InventoryTable.r_mang_sulfate);
            item.r_pneumonis = AppUtils.getArray(data,InventoryTable.r_pneumonis);
            item.r_paracetamol = AppUtils.getArray(data,InventoryTable.r_paracetamol);
            item.r_psbi = AppUtils.getArray(data,InventoryTable.r_psbi);
            item.r_psbi_care = AppUtils.getArray(data,InventoryTable.r_psbi_care);
            item.r_starving_child = AppUtils.getArray(data,InventoryTable.r_starving_child);
            item.r_starving_protocol = AppUtils.getArray(data,InventoryTable.r_starving_protocol);
            item.end_time = AppUtils.getString(data,InventoryTable.end_time);

            if (object.has("meta")) {
                try {
                    boolean b = object.getBoolean("meta");
                    if (b) {
                        item.meta = "true";
                    } else {
                        item.meta = "false";
                    }
                } catch (Exception e) {
                    JSONObject meta = null;
                    try {
                        meta = object.getJSONObject("meta");
                    }catch(Exception ex){

                    }
                    item.fields = AppUtils.getString(meta,"fields");
                    item.comments = AppUtils.getString(meta,"comments");
                }
            }
            item.checkedBy = AppUtils.getString(object,"checked_by");
            item.facility = AppUtils.getString(data,"facility");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  item;
    }
}
