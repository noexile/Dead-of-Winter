<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/boardgame.css">
<title>Dead of Winter</title>
</head>
<body>

<!-- COLONY -->
<div id="background_image"><img src="resources/theColony.JPG" id="Image1" alt=""></div>
<div id="wb_col_survivor_1"><img src="resources/survivor_token.png" id="col_survivor_1"></div>
<div id="wb_col_survivor_2"><img src="resources/survivor_token.png" id="col_survivor_2"></div>
<div id="wb_col_survivor_3"><img src="resources/survivor_token.png" id="col_survivor_3"></div>
<div id="wb_col_survivor_4"><img src="resources/survivor_token.png" id="col_survivor_4"></div>
<div id="wb_col_survivor_5"><img src="resources/survivor_token.png" id="col_survivor_5"></div>
<div id="wb_col_survivor_6"><img src="resources/survivor_token.png" id="col_survivor_6"></div>
<div id="wb_col_survivor_7"><img src="resources/survivor_token.png" id="col_survivor_7"></div>
<div id="wb_col_survivor_8"><img src="resources/survivor_token.png" id="col_survivor_8"></div>
<div id="wb_col_survivor_9"><img src="resources/survivor_token.png" id="col_survivor_9"></div>
<div id="wb_col_survivor_10"><img src="resources/survivor_token.png" id="col_survivor_10"></div>
<div id="wb_col_survivor_11"><img src="resources/survivor_token.png" id="col_survivor_11"></div>
<div id="wb_col_survivor_12"><img src="resources/survivor_token.png" id="col_survivor_12"></div>
<div id="wb_col_survivor_13"><img src="resources/survivor_token.png" id="col_survivor_13"></div>
<div id="wb_col_survivor_14"><img src="resources/survivor_token.png" id="col_survivor_14"></div>
<div id="wb_col_survivor_15"><img src="resources/survivor_token.png" id="col_survivor_15"></div>

<div id="wb_col_entr1_zombie1"><img src="resources/zombie_token.png" id="col_entr1_zombie1"></div>
<div id="wb_col_entr1_zombie2"><img src="resources/zombie_token.png" id="col_entr1_zombie2"></div>
<div id="wb_col_entr1_zombie3"><img src="resources/zombie_token.png" id="col_entr1_zombie3"></div>
<div id="wb_col_entr2_zombie1"><img src="resources/zombie_token.png" id="col_entr2_zombie1"></div>
<div id="wb_col_entr2_zombie2"><img src="resources/zombie_token.png" id="col_entr2_zombie2"></div>
<div id="wb_col_entr2_zombie3"><img src="resources/zombie_token.png" id="col_entr2_zombie3"></div>
<div id="wb_col_entr3_zombie1"><img src="resources/zombie_token.png" id="col_entr3_zombie1"></div>
<div id="wb_col_entr3_zombie2"><img src="resources/zombie_token.png" id="col_entr3_zombie2"></div>
<div id="wb_col_entr3_zombie3"><img src="resources/zombie_token.png" id="col_entr3_zombie3"></div>
<div id="wb_col_entr4_zombie1"><img src="resources/zombie_token.png" id="col_entr4_zombie1"></div>
<div id="wb_col_entr4_zombie2"><img src="resources/zombie_token.png" id="col_entr4_zombie2"></div>
<div id="wb_col_entr4_zombie3"><img src="resources/zombie_token.png" id="col_entr4_zombie3"></div>
<div id="wb_col_entr5_zombie1"><img src="resources/zombie_token.png" id="col_entr5_zombie1"></div>
<div id="wb_col_entr5_zombie2"><img src="resources/zombie_token.png" id="col_entr5_zombie2"></div>
<div id="wb_col_entr5_zombie3"><img src="resources/zombie_token.png" id="col_entr5_zombie3"></div>
<div id="wb_col_entr6_zombie1"><img src="resources/zombie_token.png" id="col_entr6_zombie1"></div>
<div id="wb_col_entr6_zombie2"><img src="resources/zombie_token.png" id="col_entr6_zombie2"></div>
<div id="wb_col_entr6_zombie3"><img src="resources/zombie_token.png" id="col_entr6_zombie3"></div>


<!-- POLICE STATION -->
<div id="wb_ps_survivor_1"><img src="resources/survivor_token.png" id="ps_survivor_1"></div>
<div id="wb_ps_survivor_2"><img src="resources/survivor_token.png" id="ps_survivor_2"></div>
<div id="wb_ps_survivor_3"><img src="resources/survivor_token.png" id="ps_survivor_3"></div>

<div id="wb_ps_zombie_1"><img src="resources/zombie_token.png" id="ps_zombie_1"></div>
<div id="wb_ps_zombie_2"><img src="resources/zombie_token.png" id="ps_zombie_2"></div>
<div id="wb_ps_zombie_3"><img src="resources/zombie_token.png" id="ps_zombie_3"></div>
<div id="wb_ps_zombie_4"><img src="resources/zombie_token.png" id="ps_zombie_4"></div>


<!-- GROCERY STORE -->
<div id="wb_gs_survivor_1"><img src="resources/survivor_token.png" id="gs_survivor_1"></div>
<div id="wb_gs_survivor_2"><img src="resources/survivor_token.png" id="gs_survivor_2"></div>
<div id="wb_gs_survivor_3"><img src="resources/survivor_token.png" id="gs_survivor_3"></div>

<div id="wb_gs_zombie_1"><img src="resources/zombie_token.png" id="gs_zombie_1"></div>
<div id="wb_gs_zombie_2"><img src="resources/zombie_token.png" id="gs_zombie_2"></div>
<div id="wb_gs_zombie_3"><img src="resources/zombie_token.png" id="gs_zombie_3"></div>
<div id="wb_gs_zombie_4"><img src="resources/zombie_token.png" id="gs_zombie_4"></div>


<!-- SCHOOL -->
<div id="wb_sch_survivor_1"><img src="resources/survivor_token.png" id="sch_survivor_1"></div>
<div id="wb_sch_survivor_2"><img src="resources/survivor_token.png" id="sch_survivor_2"></div>
<div id="wb_sch_survivor_3"><img src="resources/survivor_token.png" id="sch_survivor_3"></div>
<div id="wb_sch_survivor_4"><img src="resources/survivor_token.png" id="sch_survivor_4"></div>

<div id="wb_sch_zombie_1"><img src="resources/zombie_token.png" id="sch_zombie_1"></div>
<div id="wb_sch_zombie_2"><img src="resources/zombie_token.png" id="sch_zombie_2"></div>
<div id="wb_sch_zombie_3"><img src="resources/zombie_token.png" id="sch_zombie_3"></div>
<div id="wb_sch_zombie_4"><img src="resources/zombie_token.png" id="sch_zombie_4"></div>


<!-- LIBRARY -->
<div id="wb_lib_survivor_1"><img src="resources/survivor_token.png" id="lib_survivor_1"></div>
<div id="wb_lib_survivor_2"><img src="resources/survivor_token.png" id="lib_survivor_2"></div>
<div id="wb_lib_survivor_3"><img src="resources/survivor_token.png" id="lib_survivor_3"></div>

<div id="wb_lib_zombie_1"><img src="resources/zombie_token.png" id="lib_zombie_1"></div>
<div id="wb_lib_zombie_2"><img src="resources/zombie_token.png" id="lib_zombie_2"></div>
<div id="wb_lib_zombie_3"><img src="resources/zombie_token.png" id="lib_zombie_3"></div>


<!-- HOSPITAL -->
<div id="wb_hosp_survivor_1"><img src="resources/survivor_token.png" id="hosp_survivor_1"></div>
<div id="wb_hosp_survivor_2"><img src="resources/survivor_token.png" id="hosp_survivor_2"></div>
<div id="wb_hosp_survivor_3"><img src="resources/survivor_token.png" id="hosp_survivor_3"></div>
<div id="wb_hosp_survivor_4"><img src="resources/survivor_token.png" id="hosp_survivor_4"></div>

<div id="wb_hosp_zombie_1"><img src="resources/zombie_token.png" id="hosp_zombie_1"></div>
<div id="wb_hosp_zombie_2"><img src="resources/zombie_token.png" id="hosp_zombie_2"></div>
<div id="wb_hosp_zombie_3"><img src="resources/zombie_token.png" id="hosp_zombie_3"></div>
<div id="wb_hosp_zombie_4"><img src="resources/zombie_token.png" id="hosp_zombie_4"></div>


<!-- GAS STATION -->
<div id="wb_gas_survivor_1"><img src="resources/survivor_token.png" id="gas_survivor_1"></div>
<div id="wb_gas_survivor_2"><img src="resources/survivor_token.png" id="gas_survivor_2"></div>

<div id="wb_gas_zombie_1"><img src="resources/zombie_token.png" id="gas_zombie_1"></div>
<div id="wb_gas_zombie_2"><img src="resources/zombie_token.png" id="gas_zombie_2"></div>
<div id="wb_gas_zombie_3"><img src="resources/zombie_token.png" id="gas_zombie_3"></div>


<!-- ROUNDS -->
<div id="wb_round10"><img src="resources/round_token.png" id="round10"></div>
<div id="wb_round9"><img src="resources/round_token.png" id="round9"></div>
<div id="wb_round8"><img src="resources/round_token.png" id="round8"></div>
<div id="wb_round7"><img src="resources/round_token.png" id="round7"></div>
<div id="wb_round6"><img src="resources/round_token.png" id="round6"></div>
<div id="wb_round5"><img src="resources/round_token.png" id="round5"></div>
<div id="wb_round4"><img src="resources/round_token.png" id="round4"></div>
<div id="wb_round3"><img src="resources/round_token.png" id="round3"></div>
<div id="wb_round2"><img src="resources/round_token.png" id="round2"></div>
<div id="wb_round1"><img src="resources/round_token.png" id="round1"></div>
<div id="wb_round0"><img src="resources/round_token.png" id="round0"></div>


<!-- MORALE -->
<div id="wb_morale10"><img src="resources/morale_token.png" id="morale10"></div>
<div id="wb_morale9"><img src="resources/morale_token.png" id="morale9"></div>
<div id="wb_morale8"><img src="resources/morale_token.png" id="morale8"></div>
<div id="wb_morale7"><img src="resources/morale_token.png" id="morale7"></div>
<div id="wb_morale6"><img src="resources/morale_token.png" id="morale6"></div>
<div id="wb_morale5"><img src="resources/morale_token.png" id="morale5"></div>
<div id="wb_morale4"><img src="resources/morale_token.png" id="morale4"></div>
<div id="wb_morale3"><img src="resources/morale_token.png" id="morale3"></div>
<div id="wb_morale2"><img src="resources/morale_token.png" id="morale2"></div>
<div id="wb_morale1"><img src="resources/morale_token.png" id="morale1"></div>
<div id="wb_morale0"><img src="resources/morale_token.png" id="morale0"></div>


<!-- MAIN OBJECTIVE -->
<div id="main_objective_form"><img src="resources/we_need_more_samples_normal.png" id="main_objective"></div>

<!-- FOOD SUPPLY -->
<!-- TODO set supply in session / application -->
<div id="food_supply_count"><h1><c:out value="${1}"></c:out></h1></div>


<input type="submit" id="Button1" name="" value="End Turn" style="position:absolute;left:1536px;top:1000px;width:135px;height:42px;z-index:98;">
<input type="submit" id="Button2" name="" value="" style="position:absolute;left:1641px;top:0px;width:37px;height:37px;z-index:99;">
<div id="round_summary" style="position:absolute;left:1271px;top:784px;width:370px;height:144px;z-index:100;background-color: lightblue;">
</div>
<div id="player_options_frame" style="position:absolute;left:1271px;top:329px;width:363px;height:418px;z-index:101;background-color: lightblue;">
</div>
<div id="player_cards_frame" style="position:absolute;left:499px;top:843px;width:659px;height:157px;z-index:102;background-color: lightblue;">
</div>
<div id="survivors_frame" style="position:absolute;left:28px;top:321px;width:378px;height:679px;z-index:103;background-color: lightblue;">
</div>
<div id="ps_survivor_names" style="position:absolute;left:60px;top:67px;width:158px;height:90px;z-index:104;background-color: lightblue;">
</div>
<div id="gs_survivor_names" style="position:absolute;left:336px;top:67px;width:158px;height:90px;z-index:105;background-color: lightblue;">
</div>
<div id="sch_survivor_names" style="position:absolute;left:604px;top:67px;width:158px;height:90px;z-index:106;background-color: lightblue;">
</div>
<div id="lib_survivor_names" style="position:absolute;left:879px;top:67px;width:158px;height:90px;z-index:107;background-color: lightblue;">
</div>
<div id="hosp_survivor_names" style="position:absolute;left:1158px;top:67px;width:158px;height:90px;z-index:108;background-color: lightblue;">
</div>
<div id="gas_survivor_names" style="position:absolute;left:1434px;top:67px;width:158px;height:90px;z-index:109;background-color: lightblue;">
</div>

<div id="crisis_card_form" style="position:absolute;left:493px;top:624px;width:102px;height:160px;z-index:111;background-color: lightblue;">
</div>
<div id="waste_pile_form" style="position:absolute;left:645px;top:445px;width:107px;height:163px;z-index:112;background-color: lightblue;">
</div>
<div id="crisis_contribution_form" style="position:absolute;left:605px;top:649px;width:147px;height:116px;z-index:113;background-color: lightblue;">
</div>

</body>
</html>