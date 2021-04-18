/**
 * if I want to split the players use the same type, for instance 
 * IF if I have 4 type 1 they split by group of 2, in sequence order 
 *  */ 

const names = [
	{name: 'Elias', type: 1},
	{name: 'Fergal', type: 1},
	
	{name: 'Conor', type: 1},
	{name: 'Tarik', type: 1},

	{name: 'Barry', type: 2},
  {name: 'Nial', type: 2},
  
  {name: 'Eoghan'},
  {name: 'Gary'},
  
  {name: 'Bruno'},
	{name: 'Uzair'},


  {name: 'John'},
	{name: 'Dave'},

]

const maxLevel = 4;

const separateTeam = (allPlayers) => {
	let teamA = [];
	while(teamA.length/2 < allPlayers.length/2) {

		const picked = allPlayers[Math.floor(Math.random() * allPlayers.length)];

		const getIndex = () => allPlayers.findIndex( (item, index) => item.name === picked.name )

		allPlayers.splice(getIndex(), 1)

		//console.log('names',names)

		teamA.push(picked);
	}

	return {teamA: teamA, teamB: allPlayers}
}

const build = (currentLevel) => {
	//console.log('FUll',names)
	if(currentLevel <= maxLevel) {
		let listPerLevel = names.filter(player => player.type === currentLevel)
		return separateTeam(listPerLevel)
	} else {
		let listPerLevel = names.filter(player => !player.type)
		return separateTeam(listPerLevel)
	}
}

function init() {
	let teamA = []
	let teamB = []

	let currentLevel = 1;
	while(maxLevel + 1 >= currentLevel ){
		let result = build(currentLevel++)
		teamA = teamA.concat(result.teamA)
		teamB = teamB.concat(result.teamB)
	}
	console.log('Team A= ', teamA.map(p => p.name));
	console.log('Team B= ', teamB.map(p => p.name));
}
init();




