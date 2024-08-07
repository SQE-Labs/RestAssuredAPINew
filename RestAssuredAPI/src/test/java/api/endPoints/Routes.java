package api.endPoints;

public class Routes {

	
	
	
	
	/* https://petstore.swagger.io/v2/user
	 * https://petstore.swagger.io/v2/user/{username}
	 * https://petstore.swagger.io/v2/user/{username}
	 * https://petstore.swagger.io/v2/user/{username}
	 
	 */
	
	
	public static String base_url  = "https://petstore.swagger.io/v2";

	
	// user module urls
    public static String post_url = base_url+"/user";
    public static String get_url = base_url + "/user/{username}";
    public static String put_url = base_url + "/user/{username}";
    public static String del_url = base_url + "/user/{username}";
    public static String login_url = base_url+"/user/login";

    
    // pet module urls
    
    //https://petstore.swagger.io/v2/pet
    
    // create a new pet data
    public static String pet_post_url = base_url+"/pet";
    
    // get pet data by pet id
    public static String pet_get_url = base_url + "/pet/{petId}";
    
    // update a pet in the store with form data
    public static String pet_put_url = base_url + "/pet/{petId}";
    
    // delete a pet 
    public static String pet_del_url = base_url + "/pet/{petId}";
    
    // upload image in pet store 
    public static String pet_uploadeImage_url = base_url + "/pet/{petId}/uploadImage" ;
    
    // get pet data by status
    public static String pet_get_status_url = base_url + "/pet/findByStatus";
    
    // update pet 
    
    public static String pets_put__url = base_url + "/pet";
    
    
    
    
    
    
    
    
    
    //store module urls
    



}
