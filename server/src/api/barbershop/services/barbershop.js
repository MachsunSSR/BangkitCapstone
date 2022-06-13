'use strict';

/**
 * barbershop service.
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::barbershop.barbershop');
