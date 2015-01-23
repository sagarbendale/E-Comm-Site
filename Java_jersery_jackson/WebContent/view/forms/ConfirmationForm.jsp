	<form role="form" action="OrderConfirmation" method="post">
					<div class="form-group">
						<label for="Address1">Address:</label> <input type="text"
							name="address1" placeholder="Line 1" class="form-display">
					</div>
					<div class="form-group">
						<input type="text" name="address2" placeholder="Line 2"
							class="form-display">
					</div>
					<div class="form-group">
						<label for="Address2">City:</label> <input type="text" name="city"
							class="form-display">
					</div>
					<div class="form-group">
						<label for="Address2">State:</label> <input type="text"
							name="state" class="form-display">
					</div>
					<div class="form-group">
						<label for="Address2">Zipcode:</label> <input type="text"
							name="zip" placeholder="e.g. 95112" class="form-display">
					</div>

					<hr>
					<hr>

					<label for="cardholdername">Card Holders Name</label>

					<div class="form-group">
						<input type="text" name="ccholder" class="form-display">
					</div>
					<div class="form-group">
						<label class="paylabel" for="cardtype">Card Type:</label> <select
							id="cardtype" name="cctype">
							<option value="selectcard">--- Please select ---</option>
							<option value="mastercard">Mastercard</option>
							<option value="maestro">Maestro</option>
							<option value="solo">Solo (UK only)</option>
							<option value="visaelectron">Visa Electron</option>
							<option value="visadebit">Visa Debit</option>
						</select><br /> <label for="Credit Card">Credit Card Number</label> <input
							type="text" name="ccno" class="form-display">
					</div>

					<div class="form-group">
						<label for="securitycode">Security Code:</label> <input
							type="text" name="ccsec" class="form-display">
					</div>


					<button type="submit" class="btn btn-default">Submit</button>
					 <a class="btn" href="http://localhost:8080/#/store/TV">Cancel</a>
				</form>