const droneFactory = () => {

    // 100 drones
    // duplicate ids
    // one unique
    return {

        findMissingDrone(deliveryIdConfirmations) {
            //let droneConfirmationMap = new Map()
            //deliveryIdConfirmations.forEach( item => {
            //    if(droneConfirmationMap.has(item)) {
            //        droneConfirmationMap.set(item, droneConfirmationMap.get(item) + 1)
            //    } else {
            //        droneConfirmationMap.set(item, 1)
            //    }
            //});
            let droneConfirmationMap = deliveryIdConfirmations.reduce( (acc, item) => {
                if(acc.has(item)) {
                    acc.set(item, acc.get(item) + 1)
                } else {
                    acc.set(item, 1)
                }
                return acc;
            }, new Map());


            console.log('Fill up', droneConfirmationMap)


            for(let [key,value] of droneConfirmationMap) {
                if(value  === 1) {
                    return key;
                }
            }
            return null;
        }
    }
};

const res = droneFactory().findMissingDrone([2,5,98,2,98])

//console.assert(res === 5)

console.log('Success found', res)

