package com.healthtimejournal.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.healthtimejournal.model.CategoryReferenceModel;
import com.healthtimejournal.model.ChildModel;
import com.healthtimejournal.model.CommentModel;
import com.healthtimejournal.model.DiseaseDictionaryModel;
import com.healthtimejournal.model.DoctorModel;
import com.healthtimejournal.model.Event;
import com.healthtimejournal.model.FamilyModel;
import com.healthtimejournal.model.GalleryModel;
import com.healthtimejournal.model.Hashtag;
import com.healthtimejournal.model.ParentModel;
import com.healthtimejournal.model.ParentPrivilegeModel;
import com.healthtimejournal.model.ParentSicknessModel;
import com.healthtimejournal.model.PostModel;
import com.healthtimejournal.model.SharingDoctorModel;
import com.healthtimejournal.model.SharingModel;

public class JSONParser {

	public static ChildModel getOneChild(String data){
		try{
			ChildModel model = new ChildModel();
			JSONObject jobj = new JSONObject(data);
			JSONArray jArray = jobj.getJSONArray("child");

			JSONObject oneObj = jArray.getJSONObject(0);
			model.setChildId(oneObj.getInt("child_id"));
			model.setFirstName(oneObj.getString("first_name"));
			model.setLastName(oneObj.getString("last_name"));
			if(oneObj.getInt("gender") == 1)
				model.setGender("Male");
			else
				model.setGender("Female");
			model.setBirthdate(oneObj.getString("birthdate"));
			model.setBloodType(oneObj.getString("blood_type"));
			model.setFamilyId(oneObj.getInt("family_id"));
			
			return model;
		} catch(JSONException e){
			e.printStackTrace();
		}

		return null;
	}

	public static List<CategoryReferenceModel> getCategoryReference(String data){
		List<CategoryReferenceModel> result = new ArrayList<CategoryReferenceModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("hashtags");

			JSONObject oneobj = null;

			for(int i = 0; i < jArray.length(); i++){
				CategoryReferenceModel onecategory = new CategoryReferenceModel();
				oneobj = jArray.getJSONObject(i);

				onecategory.setCategoryId(oneobj.getInt("category_id"));
				onecategory.setCategoryName(oneobj.getString("category_name"));

				result.add(onecategory);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<ChildModel> getChild(String data){
		List<ChildModel> result = new ArrayList<ChildModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("child");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				ChildModel onechild = new ChildModel();
				oneobj = jArray.getJSONObject(i);

				onechild.setChildId(oneobj.getInt("child_id"));
				onechild.setFirstName(oneobj.getString("first_name"));
				onechild.setLastName(oneobj.getString("last_name"));
				onechild.setGender(oneobj.getString("gender"));
				onechild.setBirthdate(oneobj.getString("birthdate"));
				onechild.setBloodType(oneobj.getString("blood_type"));
				onechild.setFamilyId(oneobj.getInt("family_id"));
				//				onechild.setChildImageId(oneobj.getInt("child_image_id"));

				result.add(onechild);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<CommentModel> getComment(String data){
		List<CommentModel> result = new ArrayList<CommentModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("child");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				CommentModel onecomment = new CommentModel();
				oneobj = jArray.getJSONObject(i);

				onecomment.setCommentId(oneobj.getInt("comment_id"));
				onecomment.setPostId(oneobj.getInt("post_id"));
				onecomment.setParentId(oneobj.getInt("parent_id"));
				//				onecomment.setImage(oneobj.getInt("first_name"));
				//onecomment.setParentFirstName(oneobj.getString("first_name"));
				//onecomment.setParentLastName(oneobj.getString("last_name"));
				onecomment.setCommentDate(oneobj.getString("comment_date"));
				onecomment.setCommentContent(oneobj.getString("comment_content"));

				result.add(onecomment);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static FamilyModel getOneFamily(String data){

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("family");

			JSONObject oneobj = null;
			FamilyModel onefamily = new FamilyModel();
			oneobj = jArray.getJSONObject(0);

			onefamily.setFamilyId(oneobj.getInt("family_id"));
			onefamily.setFatherId(oneobj.getInt("father_id"));
			onefamily.setMotherId(oneobj.getInt("mother_id"));

			return onefamily;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<FamilyModel> getFamily(String data){
		List<FamilyModel> result = new ArrayList<FamilyModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("family");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				FamilyModel onefamily = new FamilyModel();
				oneobj = jArray.getJSONObject(i);

				onefamily.setFamilyId(oneobj.getInt("family_id"));
				onefamily.setFatherId(oneobj.getInt("father_id"));
				onefamily.setMotherId(oneobj.getInt("mother_id"));

				result.add(onefamily);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public static GalleryModel getOneGallery(String data){
		GalleryModel onegallery = null;

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("gallery");

			JSONObject oneobj = null;

			for(int i = 0; i < jArray.length(); i++){
				onegallery = new GalleryModel();
				oneobj = jArray.getJSONObject(i);

				onegallery.setGalleryId(oneobj.getInt("gallery_id"));
//				onegallery.setParentId(oneobj.getInt("parent_id"));
				onegallery.setFilename(oneobj.getString("filename"));

			}
			return onegallery;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static GalleryModel getLastGallery(String data){
		GalleryModel onegallery = null;

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("gallery");

			JSONObject oneobj = null;

			for(int i = 0; i < jArray.length(); i++){
				onegallery = new GalleryModel();
				oneobj = jArray.getJSONObject(i);

				onegallery.setGalleryId(oneobj.getInt("gallery_id"));
//				onegallery.setParentId(oneobj.getInt("parent_id"));
				onegallery.setFilename(oneobj.getString("filename"));

			}
			return onegallery;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<GalleryModel> getGallery(String data){
		List<GalleryModel> result = new ArrayList<GalleryModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("gallery");

			JSONObject oneobj = null;

			for(int i = 0; i < jArray.length(); i++){
				GalleryModel onegallery = new GalleryModel();
				oneobj = jArray.getJSONObject(i);

				onegallery.setGalleryId(oneobj.getInt("gallery_id"));
//				onegallery.setParentId(oneobj.getInt("parent_id"));
				onegallery.setFilename(oneobj.getString("filename"));

				result.add(onegallery);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<Hashtag> getHashtag(String data){
		List<Hashtag> result = new ArrayList<Hashtag>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("hashtags");

			JSONObject oneobj = null;

			for(int i = 0; i < jArray.length(); i++){
				Hashtag onehash = new Hashtag();
				oneobj = jArray.getJSONObject(i);

				onehash.setHashtag_id(oneobj.getInt("tag_id"));
				onehash.setHashtag_name(oneobj.getString("tag_name"));
				onehash.setHashtag_category(oneobj.getInt("tag_category"));

				result.add(onehash);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<DoctorModel> getDoctor(String data){
		List<DoctorModel> result = new ArrayList<DoctorModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("doctor");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				DoctorModel onedoctor = new DoctorModel();
				oneobj = jArray.getJSONObject(i);

				onedoctor.setDoctorId(oneobj.getInt("doctor_id"));
				onedoctor.setParentId(oneobj.getInt("parent_id"));
				onedoctor.setSpecialty(oneobj.getString("specialty"));
				onedoctor.setHospital(oneobj.getString("hospital"));
				onedoctor.setHospitalAddress(oneobj.getString("hospital_address"));
				onedoctor.setConsultation(oneobj.getString("consultation"));
				onedoctor.setContact1(oneobj.getString("contact1"));
				onedoctor.setContact2(oneobj.getString("contact2"));

				result.add(onedoctor);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static DoctorModel getOneDoctor(String data){

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("doctor");

			JSONObject oneobj = null;
			DoctorModel onedoctor = new DoctorModel();
			oneobj = jArray.getJSONObject(0);

			onedoctor.setDoctorId(oneobj.getInt("doctor_id"));
			onedoctor.setParentId(oneobj.getInt("parent_id"));
			onedoctor.setSpecialty(oneobj.getString("specialty"));
			onedoctor.setHospital(oneobj.getString("hospital"));
			onedoctor.setHospitalAddress(oneobj.getString("hospital_address"));
			onedoctor.setConsultation(oneobj.getString("consultation"));
			onedoctor.setContact1(oneobj.getString("contact1"));
			onedoctor.setContact2(oneobj.getString("contact2"));

			return onedoctor;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<ParentModel> getParent(String data){
		List<ParentModel> result = new ArrayList<ParentModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("parent");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				ParentModel oneparent = new ParentModel();
				oneobj = jArray.getJSONObject(i);

				oneparent.setParentId(oneobj.getInt("parent_id"));
				oneparent.setFirstName(oneobj.getString("first_name"));
				oneparent.setLastName(oneobj.getString("last_name"));
				oneparent.setEmail(oneobj.getString("email"));
				oneparent.setPassword(oneobj.getString("password"));
				oneparent.setGender(oneobj.getString("gender"));
				oneparent.setBloodType(oneobj.getString("blood_type"));
//				oneparent.setParentImageId(oneobj.getInt("parent_image_id"));
//				oneparent.setAccountStatus(oneobj.getInt("account_status"));

				result.add(oneparent);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static ParentModel getOneParent(String data){

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("parents");

			JSONObject oneobj = null;
			ParentModel oneparent = new ParentModel();
			oneobj = jArray.getJSONObject(0);

			oneparent.setParentId(oneobj.getInt("parent_id"));
			oneparent.setFirstName(oneobj.getString("first_name"));
			oneparent.setLastName(oneobj.getString("last_name"));
			oneparent.setFamilyId(oneobj.getInt("family_id"));

			return oneparent;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<ParentSicknessModel> getParentSickness(String data){
		List<ParentSicknessModel> result = new ArrayList<ParentSicknessModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("sickness");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				ParentSicknessModel oneparentsickness = new ParentSicknessModel();
				oneobj = jArray.getJSONObject(i);

				oneparentsickness.setParentSicknessId(oneobj.getInt("medical_history_id"));
				oneparentsickness.setParentId(oneobj.getInt("parent_id"));
				oneparentsickness.setAnemia(oneobj.getInt("anemia"));
				oneparentsickness.setAsthma(oneobj.getInt("asthma"));
				oneparentsickness.setBleedingDis(oneobj.getInt("bleeding_disorder"));
				oneparentsickness.setDiabetes(oneobj.getInt("diabetes"));
				oneparentsickness.setEpilepsy(oneobj.getInt("epilepsy"));
				oneparentsickness.setHeartDis(oneobj.getInt("heart_disorder"));
				oneparentsickness.setHighBlood(oneobj.getInt("high_blood"));
				oneparentsickness.setHighCho(oneobj.getInt("high_cholesterol"));
				oneparentsickness.setLiverDis(oneobj.getInt("liver_disorder"));
				oneparentsickness.setKidneyDis(oneobj.getInt("kidney_disorder"));
				oneparentsickness.setNasalAll(oneobj.getInt("nasal_allergy"));
				oneparentsickness.setTuberculosis(oneobj.getInt("tuberculosis"));

				result.add(oneparentsickness);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<PostModel> getPost(String data){
		List<PostModel> result = new ArrayList<PostModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("posts");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				PostModel onepost = new PostModel();
				oneobj = jArray.getJSONObject(i);

				onepost.setPostId(oneobj.getInt("post_id"));
				onepost.setEventId(oneobj.getInt("event_id"));
				onepost.setFromParentId(oneobj.getInt("from_parent_id"));
				onepost.setPostContent(oneobj.getString("post_content"));
				onepost.setPostDate(oneobj.getString("post_date"));
				onepost.setFileId(oneobj.getInt("file_id"));
				result.add(onepost);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<Event> getEvents(String data){
		List<Event> result = new ArrayList<Event>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("events");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				Event oneevent = new Event();
				oneobj = jArray.getJSONObject(i);

				oneevent.setEventId(oneobj.getInt("event_id"));
				oneevent.setToParentId(oneobj.getInt("to_parent_id"));
				oneevent.setFromParentId(oneobj.getInt("from_parent_id"));
				oneevent.setChildId(oneobj.getInt("child_id"));
				oneevent.setEventContent(oneobj.getString("event_content"));
				oneevent.setEventDate(oneobj.getString("event_date"));
				oneevent.setEventCategory(oneobj.getInt("event_category"));
				result.add(oneevent);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<SharingModel> getSharing(String data){
		List<SharingModel> result = new ArrayList<SharingModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("parents");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				SharingModel onesharing = new SharingModel();
				oneobj = jArray.getJSONObject(i);

				onesharing.setSharingId(oneobj.getInt("sharing_id"));
				onesharing.setToParentId(oneobj.getInt("to_parent_id"));
				onesharing.setFromFamilyId(oneobj.getInt("from_family_id"));
				onesharing.setChildId(oneobj.getInt("child_id"));
				onesharing.setPrivilege(oneobj.getInt("privilege"));

				result.add(onesharing);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<SharingDoctorModel> getSharingDoctor(String data){
		List<SharingDoctorModel> result = new ArrayList<SharingDoctorModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("children");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				SharingDoctorModel onesharingdoctor = new SharingDoctorModel();
				oneobj = jArray.getJSONObject(i);

				onesharingdoctor.setSharingDoctorId(oneobj.getInt("sharing_doctor_id"));
				onesharingdoctor.setDoctorId(oneobj.getInt("doctor_id"));
				onesharingdoctor.setParentId(oneobj.getInt("parent_id"));
				onesharingdoctor.setChildId(oneobj.getInt("child_id"));

				result.add(onesharingdoctor);
			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<DiseaseDictionaryModel> getDiseaseDictionary(String data){
		List<DiseaseDictionaryModel> result = new ArrayList<DiseaseDictionaryModel>();

		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("disease");

			JSONObject oneobj = null;
			for(int i = 0; i < jArray.length(); i++){
				DiseaseDictionaryModel onediseasedictionary = new DiseaseDictionaryModel();
				oneobj = jArray.getJSONObject(i);

				onediseasedictionary.setDiseaseDictionaryId(oneobj.getInt("disease_dictionary_id"));
				onediseasedictionary.setName(oneobj.getString("name"));
				onediseasedictionary.setDescription(oneobj.getString("description"));
				onediseasedictionary.setSymptom(oneobj.getString("symptom"));
				onediseasedictionary.setTreatment(oneobj.getString("treatment"));

				result.add(onediseasedictionary);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public static List<ParentPrivilegeModel> getParentPrivilege(String data){
		List<ParentPrivilegeModel> result = null;
		
		try {
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("parent");

			JSONObject oneobj = null;
			result = new ArrayList<ParentPrivilegeModel>();
			
			for(int i = 0; i < jArray.length(); i++){
				ParentPrivilegeModel oneparent = new ParentPrivilegeModel();
				oneobj = jArray.getJSONObject(i);
				
				ParentModel parent = new ParentModel();
				parent.setParentId(oneobj.getInt("parent_id"));
				parent.setFirstName(oneobj.getString("first_name"));
				parent.setLastName(oneobj.getString("last_name"));
				parent.setEmail(oneobj.getString("email"));
				parent.setPassword(oneobj.getString("password"));
				if(oneobj.getInt("gender") == 1)
					parent.setGender("Male");
				else
					parent.setGender("Female");
				parent.setBloodType(oneobj.getString("blood_type"));
				
				SharingModel share = new SharingModel();
				share.setSharingId(oneobj.getInt("sharing_id"));
				share.setFromFamilyId(oneobj.getInt("from_family_id"));
				share.setToParentId(oneobj.getInt("to_parent_id"));
				share.setChildId(oneobj.getInt("child_id"));
				share.setPrivilege(oneobj.getInt("privilege"));
				
				oneparent.setParents(parent);
				oneparent.setShare(share);
				
				result.add(oneparent);

			}
			return result;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
