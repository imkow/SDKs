<?php

require_once('PPBaseService.php');
require_once('Permissions.php');
require_once('PPUtils.php');
/**
 * Permissions wrapper class
 * Auto generated code
 */
class PermissionsService extends PPBaseService {
	public function __construct() {
		parent::__construct('Permissions');
	}

	/**
	 * Service Call: RequestPermissions
	 * @param RequestPermissionsRequest requestPermissionsRequest
	 * @return RequestPermissionsResponse
	 * @throws APIException
	 */
	public function RequestPermissions($requestPermissionsRequest, $apiUsername=null) {
		return new RequestPermissionsResponse( PPUtils::nvpToMap( $this->call("RequestPermissions", $requestPermissionsRequest, $apiUsername)));
	}


	/**
	 * Service Call: GetAccessToken
	 * @param GetAccessTokenRequest getAccessTokenRequest
	 * @return GetAccessTokenResponse
	 * @throws APIException
	 */
	public function GetAccessToken($getAccessTokenRequest, $apiUsername=null) {
		return new GetAccessTokenResponse( PPUtils::nvpToMap( $this->call("GetAccessToken", $getAccessTokenRequest, $apiUsername)));
	}


	/**
	 * Service Call: GetPermissions
	 * @param GetPermissionsRequest getPermissionsRequest
	 * @return GetPermissionsResponse
	 * @throws APIException
	 */
	public function GetPermissions($getPermissionsRequest, $apiUsername=null) {
		return new GetPermissionsResponse( PPUtils::nvpToMap( $this->call("GetPermissions", $getPermissionsRequest, $apiUsername)));
	}


	/**
	 * Service Call: CancelPermissions
	 * @param CancelPermissionsRequest cancelPermissionsRequest
	 * @return CancelPermissionsResponse
	 * @throws APIException
	 */
	public function CancelPermissions($cancelPermissionsRequest, $apiUsername=null) {
		return new CancelPermissionsResponse( PPUtils::nvpToMap( $this->call("CancelPermissions", $cancelPermissionsRequest, $apiUsername)));
	}


}

?>