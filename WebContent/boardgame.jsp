<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/boardgame.css">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<title>Dead of Winter</title>
</head>
<body>


	<!-- BACKGROUND -->
	<div id="background_image">
		<img src="resources/theColony.JPG" id="game_map" alt="">
	</div>


	<!-- COLONY -->
	<c:if test="${sessionScope.map.getColony().getSurvivors().size() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getColony().getSurvivors().size() - 1}">
			<div id="wb_col_survivor_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getColony().getSurvivors().get(i).getLink()}" id="col_survivor_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${sessionScope.map.getColony().getOcupiedPlaces() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getColony().getOcupiedPlaces() - 1}">
			<div id="wb_col_entr1_zombie<c:out value="${i}"/>">
				<img src="${sessionScope.map.getColony().getEntrance().getPlaces().get(i).getOccupant().getLink()}" id="col_entr1_zombie<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>


	<!-- POLICE STATION -->
	<div id="ps_survivor_names"></div>

	<c:if test="${sessionScope.map.getPoliceStation().getSurvivors().size() > 0}">
		<c:forEach var="i" begin="0"
			end="${sessionScope.map.getPoliceStation().getSurvivors().size() - 1}">
			<div id="wb_ps_survivor_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getPoliceStation().getSurvivors().get(i).getLink()}" id="ps_survivor_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>

	<c:if test="${sessionScope.map.getPoliceStation().getOcupiedPlaces() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getPoliceStation().getOcupiedPlaces() - 1}">
			<div id="wb_ps_zombie_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getPoliceStation().getEntrance().getPlaces().get(i).getOccupant().getLink()}" id="ps_zombie_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>


	<!-- GROCERY STORE -->
	<div id="gs_survivor_names"></div>

	<c:if test="${sessionScope.map.getGroceryStore().getSurvivors().size() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getGroceryStore().getSurvivors().size() - 1}">
			<div id="wb_gs_survivor_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getGroceryStore().getSurvivors().get(i).getLink()}" id="gs_survivor_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>

	<c:if test="${sessionScope.map.getGroceryStore().getOcupiedPlaces() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getGroceryStore().getOcupiedPlaces() - 1}">
			<div id="wb_gs_zombie_<c:out value="${i}"/>">
				<img id="gs_zombie_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>


	<!-- SCHOOL -->
	<div id="sch_survivor_names"></div>

	<c:if test="${sessionScope.map.getSchool().getSurvivors().size() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getSchool().getSurvivors().size() - 1}">
			<div id="wb_sch_survivor_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getSchool().getSurvivors().get(i).getLink()}" id="sch_survivor_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>

	<c:if test="${sessionScope.map.getSchool().getOcupiedPlaces() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getSchool().getOcupiedPlaces() - 1}">
			<div id="wb_sch_zombie_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getSchool().getEntrance().getPlaces().get(i).getOccupant().getLink()}" id="sch_zombie_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>


	<!-- LIBRARY -->
	<div id="lib_survivor_names"></div>

	<c:if test="${sessionScope.map.getLibrary().getSurvivors().size() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getLibrary().getSurvivors().size() - 1}">
			<div id="wb_lib_survivor_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getLibrary().getSurvivors().get(i).getLink()}" id="lib_survivor_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>

	<c:if test="${sessionScope.map.getLibrary().getOcupiedPlaces() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getLibrary().getOcupiedPlaces() - 1}">
			<div id="wb_lib_zombie_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getLibrary().getEntrance().getPlaces().get(i).getOccupant().getLink()}" id="lib_zombie_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>


	<!-- HOSPITAL -->
	<div id="hosp_survivor_names"></div>

	<c:if test="${sessionScope.map.getHospital().getSurvivors().size() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getHospital().getSurvivors().size() - 1}">
			<div id="wb_hosp_survivor_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getHospital().getSurvivors().get(i).getLink()}" id="hosp_survivor_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>

	<c:if test="${sessionScope.map.getHospital().getOcupiedPlaces() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getHospital().getOcupiedPlaces() - 1}">
			<div id="wb_hosp_zombie_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getHospital().getEntrance().getPlaces().get(i).getOccupant().getLink()}" id="hosp_zombie_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>


	<!-- GAS STATION -->
	<div id="gas_survivor_names"></div>

	<c:if test="${sessionScope.map.getGasStation().getSurvivors().size() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getGasStation().getSurvivors().size() - 1}">
			<div id="wb_gas_survivor_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getGasStation().getSurvivors().get(i).getLink()}" id="gas_survivor_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>

	<c:if test="${sessionScope.map.getGasStation().getOcupiedPlaces() > 0}">
		<c:forEach var="i" begin="0" end="${sessionScope.map.getGasStation().getOcupiedPlaces() - 1}">
			<div id="wb_gas_zombie_<c:out value="${i}"/>">
				<img src="${sessionScope.map.getGasStation().getEntrance().getPlaces().get(i).getOccupant().getLink()}" id="gas_zombie_<c:out value="${i}"/>">
			</div>
		</c:forEach>
	</c:if>


	<!-- ROUNDS -->
	<div id="wb_round<c:out value="${sessionScope.player.getRound()}"></c:out>">
		<img src="resources/round_token.png" id="round<c:out value="${sessionScope.player.round}"></c:out>">
	</div>


	<!-- MORALE -->
	<div id="wb_morale<c:out value="${sessionScope.player.getMorale()}"></c:out>">
		<img src="resources/morale_token.png" id="morale<c:out value="${sessionScope.player.morale}"></c:out>">
	</div>


	<!-- MAIN OBJECTIVE -->
	<div id="main_objective_form">
		<img id="main_objective" src="${sessionScope.player.getMainObjective().getLink()}" id="main_objective">
	</div>


	<!-- FOOD SUPPLY -->
	<div id="food_supply_count">
		<h1>
			<c:out value="${sessionScope.map.getColony().getFoodSupply()}"></c:out>
		</h1>
	</div>


	<!-- SURVIVORS -->
	<div id="survivors_frame">
		<table>
			<c:forEach items="${sessionScope.player.getSurvivors()}" var="surv">
				<tr>
					<td><img src="${surv.getLink()}" id="player_survivor_cards">
					</td>
					<td valign="top">
						<p>
							Name:
							<c:out value="${surv.getName()}"></c:out>
						</p>
						<p>
							Location:
							<c:out value="${surv.getCurrentLocation().getLocationName()}"></c:out>
						</p>
						<p>
							Damage Received:
							<c:out value="${surv.getReceivedDamage()}"></c:out>
						</p> 
						<c:if test="${surv.isHasFrostBite()}">
							<p>- Has FrostBite</p>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<!-- PLAYER CARDS -->
	<div id="player_cards_frame">
		<table>
			<tr>
				<c:if test="${sessionScope.player.getPlayerItems().size() > 0}">
					<c:forEach var="i" begin="0" end="${sessionScope.player.getPlayerItems().size() - 1}">
						<td style="text-align: center">
							<form action="OfferCardForCrisisServlet" method="post">
							<c:choose>
								<c:when test="${fn:containsIgnoreCase(sessionScope.player.getPlayerItems().get(i).getType(), player.getCurrentCrisis().getType())}">
									<input type="hidden" name="offered_card_for_crisis" value="${sessionScope.player.getPlayerItems().get(i).getType()}">
									<input type="hidden" name="card_index" value="${i}">
									<input type="submit" value="Offer">
								</c:when>
								<c:otherwise>
							   		<c:out value="${''}" />
								</c:otherwise>
							</c:choose>
							</form>
						</td>
					</c:forEach>
				</c:if>
			</tr>
			<tr>
				<c:forEach items="${sessionScope.player.getPlayerItems()}" var="items">
					<td>
						<img src="${items.getLink()}" id="player_usable_cards">
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>


	<!-- ROLLED DIES -->
	<div id="dice_frame">
		<p align="center"><b><font size="3">Dice:</font></b></p>
		<c:forEach items="${sessionScope.player.getRolledDice()}" var="rolled_dice">
			<fmt:parseNumber var="i" type="number" value="${rolled_dice}" />
			<p align="center"><b><font size="3"><c:out value="${i}" /></font></b></p>
		</c:forEach>
	</div>
	
	
	<!--  TODO barricades in PLAYER OPTIONS -->


	<!-- PLAYER OPTIONS -->
	<div id="player_options_frame">
		<table style="border-collapse: collapse;">
			<tr style="border-bottom: solid red;">
				<form action="MoveServlet" method="post">
					<font color="red"><c:out value="${sessionScope.moveError}" /></font>
					<c:remove var="moveError" scope="session" />
					<td style="padding: 25px 5px 25px 5px">
						<select name="selected_survivor">
							<c:forEach items="${sessionScope.player.getSurvivors()}" var="surv_to_move">
								<option value="${surv_to_move.getName()}"><c:out value="${surv_to_move.getName()}"></c:out></option>
							</c:forEach>
						</select>
					</td>
					<td>
						<select name="selected_location_to_move">
							<c:forEach items="${sessionScope.map.getMap()}" var="pickedLocation">
								<option value="${pickedLocation.getLocationName()}"><c:out value="${pickedLocation.getLocationName()}"></c:out></option>
							</c:forEach>
						</select>
					</td>
					<td><input type="checkbox" name="use_fuel" value="usedFuel">Use Fuel<br></td>
					<td><input type="submit" value="Move"></td>
				</form>
			</tr>

			<tr>
			<!-- ATTACK SERVLET -->
			<form action="AttackServlet" method="post">
				<font color="red"><c:out value="${sessionScope.noZombieError}" /></font>
 				<c:remove var="noZombieError" scope="session" />
				
				<td style="padding: 25px 5px 5px 5px">
					<select name="selected_survivor">
						<c:forEach items="${sessionScope.player.getSurvivors()}" var="surv_to_move">
							<option value="${surv_to_move.getName()}">
								<c:out value="${surv_to_move.getName()}"></c:out>
							</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select>
						<option>
						<c:forEach items="${sessionScope.player.getRolledDice()}" var="rolled_dice">
							<fmt:parseNumber var="i" type="number" value="${rolled_dice}" />
							<option value="${rolled_dice}"><c:out value="${rolled_dice}"></c:out></option>
						</c:forEach>
						</option>
					</select>
				</td>
				<td></td>
				<td><input type="submit" value="Attack"></td>
				
			</form>
			</tr>
			<tr style="border-bottom: solid red;">
			<!-- SEARCH SERVLET -->
			<form action="SearchServlet" method="post"> 
 				<font color="red"><c:out value="${sessionScope.searchError}" /></font>
 				<c:remove var="searchError" scope="session" />
 				<font color="blue"><c:out value="${sessionScope.searchMsg}" /></font>
 				<c:remove var="searchMsg" scope="session" />
 				
  				<td style="padding: 25px 5px 25px 5px">	 					 			
	 			<select name="selected_survivor">
	  				<c:forEach items="${sessionScope.player.getSurvivors()}" var="surv_to_move">
	  					<option value="${surv_to_move.getName()}">
	  					<c:out value="${surv_to_move.getName()}"></c:out></option>
	  			  	</c:forEach>		  			  	
	 			</select>	
 				<c:set var="searchLocation" scope="session" value="${surv_to_move.getCurrentLocation() }"/>
  				</td>
				<td>
					<select>
						<option>
						<c:forEach items="${sessionScope.player.getRolledDice()}" var="rolled_dice">
							<fmt:parseNumber var="i" type="number" value="${rolled_dice}" />
							<option value="${rolled_dice}"><c:out value="${rolled_dice}"></c:out></option>
						</c:forEach>
						</option>
					</select>
				</td>
				<td></td>
				<td><input type="submit" value="Search"></td>
				</form>
			</tr>
			<!-- HEALING SERVLET -->
			<tr style="border-bottom: solid red;">
				<form action="HealServlet" method="post">
					<font color="red"><c:out value="${sessionScope.healError}" /></font>
 					<c:remove var="healError" scope="session" />
 					<font color="blue"><c:out value="${sessionScope.healMsg}" /></font>
 					<c:remove var="healMsg" scope="session" />
					<td style="padding: 25px 5px 25px 5px">
						<select name="selected_survivor">
							<c:forEach items="${sessionScope.player.getSurvivors()}" var="surv_to_move">
								<option value="${surv_to_move.getName()}"><c:out value="${surv_to_move.getName()}"></c:out></option>
							</c:forEach>
						</select>
					</td>
					<td></td>
					<td></td>
					<td><input type="submit" value="Heal"></td>
				</form>
			</tr>
			<!-- CLEANE WASTEPILE SERVLET -->
			<tr>
				<td>
					<select>
						<option>
						<c:forEach items="${sessionScope.player.getRolledDice()}" var="rolled_dice">
							<fmt:parseNumber var="i" type="number" value="${rolled_dice}" />
							<option value="${rolled_dice}"><c:out value="${rolled_dice}"></c:out></option>
						</c:forEach>
						</option>
					</select>
				</td>
				<td></td>
				<form action="CleanWastepileServlet" method="post">
				<td colspan="2" style="padding: 25px 5px 25px 5px">
					<input type="Submit" value="Clean Wastepile">
				</td>
				</form>
			</tr>
		</table>
	</div>


	<!-- CRISIS CARDS -->
	<div id="crisis_card_form">
		<img src="${player.getCurrentCrisis().getLink()}" id="main_objective">
	</div>


	<!-- CRISIS CONTRIBUTIONS -->
	<!-- TODO -->
	<div id="crisis_contributions_form">
		<p>
			<font size="6" color="red"><c:out value="${sessionScope.map.getColony().getCrisisContributionCards()}" /></b></font>
		</p>
	</div>


	<!-- WASTE PILE -->
	<div id="waste_pile_form">
		<p>
			<font size="6" color="red">Cards:</b></font>
		</p>
		<p>
			<font size="6" color="red"><b><c:out value="${sessionScope.map.getColony().getWastePileSize()}"></c:out></b></font>
		</p>
	</div>


	<!-- TODO -->
	<input type="submit" id="Button2" name="" value="END TURN" style="position: absolute; left: 1641px; top: 0px; width: 37px; height: 37px; z-index: 99;">


	<!-- TODO -->
	<div id="round_summary" style="position: absolute; left: 1271px; top: 784px; width: 370px; height: 144px; z-index: 100; background-color: lightblue;">
	</div>


</body>
</html>